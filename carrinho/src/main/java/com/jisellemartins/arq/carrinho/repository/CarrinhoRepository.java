package com.jisellemartins.arq.carrinho.repository;

import com.jisellemartins.arq.carrinho.domain.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoRepository extends JpaRepository<Carrinho,Long> {
}
