package com.jisellemartins.arq.carrinho.repository;

import com.jisellemartins.arq.carrinho.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
}
