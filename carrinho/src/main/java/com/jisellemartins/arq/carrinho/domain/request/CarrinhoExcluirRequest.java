package com.jisellemartins.arq.carrinho.domain.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarrinhoExcluirRequest {
    private int id_carrinho;
    private int id_produto;
    private int id_usuario;
}
