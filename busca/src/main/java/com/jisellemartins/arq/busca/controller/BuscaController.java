package com.jisellemartins.arq.busca.controller;

import com.jisellemartins.arq.busca.domain.Produto;
import com.jisellemartins.arq.busca.service.BuscaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/busca")
public class BuscaController extends GenericController<Produto> {
    @Autowired
    private BuscaService service;

    public BuscaController(BuscaService service) {
        super(service);
    }

    @GetMapping(value = "/produto/{id}")
    public Produto buscarProduto(@PathVariable Integer id) {
        return service.get(id, "Produto não encontrado");
    }

}
