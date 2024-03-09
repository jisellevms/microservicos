package com.jisellemartins.arq.pagamento.component;

public interface RabbitMQComponent {
    void handleMessage(String message);
}
