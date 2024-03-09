package com.jisellemartins.arq.pagamento.repository;

import com.jisellemartins.arq.pagamento.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}