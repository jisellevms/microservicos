package com.jisellemartins.arq.pagamento.component.impl;

import com.google.gson.Gson;
import com.jisellemartins.arq.pagamento.component.RabbitMQComponent;
import com.jisellemartins.arq.pagamento.domain.Carrinho;
import com.jisellemartins.arq.pagamento.utils.Utils;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class RabbitMQComponentImpl implements RabbitMQComponent  {

    private final WebClient webClient;
    public RabbitMQComponentImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @RabbitListener(queues = "pagamento_queue")
    @Override
    public void handleMessage(String message) {
        Gson gson = new Gson();
        Carrinho carrinho = gson.fromJson(message,Carrinho.class);
        try{
            String response = this.webClient.get()
                    .uri("/cadastro/usuario/" + carrinho.getId_usuario())
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            Utils.carrinhoGlobal = carrinho;
        }catch (Exception e){
            System.out.print("Não foi possivel realizar a busca de usuário " + e.getMessage());
        }
    }
}
