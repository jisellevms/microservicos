package com.jisellemartins.arq.pagamento.controller;

import com.jisellemartins.arq.pagamento.domain.Pagamento;
import com.jisellemartins.arq.pagamento.domain.request.PagamentoRequest;
import com.jisellemartins.arq.pagamento.service.PagamentoService;
import com.jisellemartins.arq.pagamento.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/pagamento")
public class PagamentoController extends GenericController<Pagamento> {
    @Autowired
    private PagamentoService service;

    public PagamentoController(PagamentoService service) {
        super(service);
    }

    @PostMapping(value = "/pagar")
    public void incluirInformacao(@RequestBody PagamentoRequest pagamentoRequest) {
        Pagamento newPagamento = new Pagamento();
        newPagamento.setFormaPagamento(pagamentoRequest.getFormaPagamento());
        newPagamento.setStatus(pagamentoRequest.getStatus());
        newPagamento.setId_carrinho(Utils.carrinhoGlobal.getId_carrinho());
        newPagamento.setId_usuario(Utils.carrinhoGlobal.getId_usuario());
        service.save(newPagamento);
    }
}
