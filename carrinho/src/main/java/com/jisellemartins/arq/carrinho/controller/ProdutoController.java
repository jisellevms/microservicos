package com.jisellemartins.arq.carrinho.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.jisellemartins.arq.carrinho.domain.Produto;
import com.jisellemartins.arq.carrinho.service.ProdutoService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/produto")
public class ProdutoController extends GenericController<Produto> {
    @Autowired
    private ProdutoService service;
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    private final AmqpTemplate rabbitTemplate;

    public ProdutoController(ProdutoService service, AmqpTemplate rabbitTemplate) {
        super(service);
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        service.delete(id);
    }

    @PostMapping(value = "/incluir")
    public void incluirInformacao(@RequestBody Produto produto) {
        sendNotification(produto);
        service.save(produto);
    }

    public void sendNotification(Produto produto) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());

            String json = mapper.writeValueAsString(produto);

            rabbitTemplate.convertAndSend(exchange, routingKey, json);
        } catch (JsonProcessingException e) {
        }
    }
}
