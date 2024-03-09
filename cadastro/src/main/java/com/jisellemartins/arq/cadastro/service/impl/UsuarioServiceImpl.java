package com.jisellemartins.arq.cadastro.service.impl;

import com.jisellemartins.arq.cadastro.domain.Usuario;
import com.jisellemartins.arq.cadastro.repository.UsuarioRepository;
import com.jisellemartins.arq.cadastro.service.UsuarioService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, Long, UsuarioRepository> implements UsuarioService {
    public UsuarioServiceImpl(UsuarioRepository repository){ super(repository); }
}
