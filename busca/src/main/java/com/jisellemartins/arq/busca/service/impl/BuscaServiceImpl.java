package com.jisellemartins.arq.busca.service.impl;


import com.jisellemartins.arq.busca.domain.Produto;
import com.jisellemartins.arq.busca.repository.BuscaRepository;
import com.jisellemartins.arq.busca.service.BuscaService;
import org.springframework.stereotype.Service;

@Service
public class BuscaServiceImpl extends GenericServiceImpl<Produto, Long, BuscaRepository> implements BuscaService {
    public BuscaServiceImpl(BuscaRepository repository) {
        super(repository);
    }
}
