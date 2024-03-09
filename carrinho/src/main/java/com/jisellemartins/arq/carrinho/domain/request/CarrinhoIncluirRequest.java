package com.jisellemartins.arq.carrinho.domain.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CarrinhoIncluirRequest {
    private int id_usuario;
    private List<Integer> id_produtos;
}
