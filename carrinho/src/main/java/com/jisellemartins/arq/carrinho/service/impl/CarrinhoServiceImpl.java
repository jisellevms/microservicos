package com.jisellemartins.arq.carrinho.service.impl;

import com.jisellemartins.arq.carrinho.domain.Carrinho;
import com.jisellemartins.arq.carrinho.repository.CarrinhoRepository;
import com.jisellemartins.arq.carrinho.service.CarrinhoService;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoServiceImpl extends GenericServiceImpl<Carrinho, Long, CarrinhoRepository> implements CarrinhoService {
    public CarrinhoServiceImpl(CarrinhoRepository repository){ super(repository); }
}
