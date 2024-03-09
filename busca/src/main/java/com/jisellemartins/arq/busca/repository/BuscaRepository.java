package com.jisellemartins.arq.busca.repository;


import com.jisellemartins.arq.busca.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuscaRepository extends JpaRepository<Produto,Long> {
}
