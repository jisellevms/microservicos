package com.jisellemartins.arq.carrinho.service.impl;

import com.jisellemartins.arq.carrinho.domain.Produto;
import com.jisellemartins.arq.carrinho.repository.ProdutoRepository;
import com.jisellemartins.arq.carrinho.service.ProdutoService;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl extends GenericServiceImpl<Produto, Long, ProdutoRepository> implements ProdutoService {
    public ProdutoServiceImpl(ProdutoRepository repository) {
        super(repository);
    }
}
