package com.jisellemartins.arq.pagamento.domain;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Produto {
    private int id_produto;
    private String nome_produto;
    private int valor;
    private int quantidade;
}