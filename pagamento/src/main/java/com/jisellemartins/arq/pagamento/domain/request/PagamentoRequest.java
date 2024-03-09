package com.jisellemartins.arq.pagamento.domain.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagamentoRequest {
    private String formaPagamento;
    private String status;
}
