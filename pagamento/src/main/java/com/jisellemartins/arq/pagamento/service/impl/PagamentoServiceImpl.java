package com.jisellemartins.arq.pagamento.service.impl;


import com.jisellemartins.arq.pagamento.domain.Pagamento;
import com.jisellemartins.arq.pagamento.repository.PagamentoRepository;
import com.jisellemartins.arq.pagamento.service.PagamentoService;
import org.springframework.stereotype.Service;

@Service
public class PagamentoServiceImpl extends GenericServiceImpl<Pagamento, Long, PagamentoRepository> implements PagamentoService {
    public PagamentoServiceImpl(PagamentoRepository repository){ super(repository); }
}
