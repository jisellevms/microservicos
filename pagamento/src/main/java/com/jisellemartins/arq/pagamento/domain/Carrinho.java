package com.jisellemartins.arq.pagamento.domain;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Carrinho {
    private int id_carrinho;
    private String produtos;
    private int id_usuario;
}
