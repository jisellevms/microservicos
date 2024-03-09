package com.jisellemartins.arq.carrinho.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jisellemartins.arq.carrinho.domain.Carrinho;
import com.jisellemartins.arq.carrinho.domain.Produto;
import com.jisellemartins.arq.carrinho.domain.request.CarrinhoExcluirRequest;
import com.jisellemartins.arq.carrinho.domain.request.CarrinhoIncluirRequest;
import com.jisellemartins.arq.carrinho.service.CarrinhoService;
import com.jisellemartins.arq.carrinho.service.ProdutoService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("api/carrinho")
public class CarrinhoController extends GenericController<Carrinho> {
    @Autowired
    private CarrinhoService service;
    @Autowired
    private ProdutoService serviceProduto;
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    private final AmqpTemplate rabbitTemplate;

    public CarrinhoController(CarrinhoService service, AmqpTemplate rabbitTemplate) {
        super(service);
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping(value = "/excluir")
    public void excluir(@RequestBody CarrinhoExcluirRequest request) {
        Carrinho p = service.get(request.getId_carrinho(), "Esse carrinho não existe");
        Gson gson = new Gson();
        String jsonInString = p.getProdutos();
        List<Produto> produtos= gson.fromJson(jsonInString,new TypeToken<List<Produto>>(){}.getType());
        List<Produto> newProdutos = new ArrayList<>();
        for (Produto produto : produtos) {
            if (!(request.getId_produto() == produto.getId_produto())){
                newProdutos.add(produto);
            }
        }
        Carrinho carrinho = new Carrinho();
        carrinho.setProdutos(new Gson().toJson(newProdutos));
        carrinho.setId_carrinho(request.getId_carrinho());
        carrinho.setId_usuario(request.getId_usuario());
        service.update(carrinho);
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody CarrinhoIncluirRequest request) {
        List<Produto> produtos = new ArrayList<>();
        for (Integer i : request.getId_produtos()) {
            Produto p = serviceProduto.get(i, "Esse produto não existe");
            produtos.add(p);
        }
        String json = new Gson().toJson(produtos);
        Random rand = new Random();
        int id = rand.nextInt(1000);
        Carrinho carrinho = new Carrinho();
        carrinho.setId_carrinho(id);
        carrinho.setProdutos(json);
        carrinho.setId_usuario(request.getId_usuario());
        service.save(carrinho);
    }

    @PostMapping(value = "/pagamento")
    public void incluir(@RequestBody Integer id_carrinho) {
        Carrinho p = service.get(id_carrinho, "Esse carrinho não existe");
        String json = new Gson().toJson(p);
        sendNotification(json);
    }

    public void sendNotification(String json) {
        rabbitTemplate.convertAndSend(exchange, routingKey, json);
    }
}