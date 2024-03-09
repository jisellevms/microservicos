package com.jisellemartins.arq.cadastro.controller;

import com.jisellemartins.arq.cadastro.domain.Usuario;
import com.jisellemartins.arq.cadastro.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cadastro")
public class UsuarioController extends GenericController<Usuario> {
    @Autowired
    private UsuarioService service;

    public UsuarioController(UsuarioService service) {
        super(service);
    }

    @PostMapping(value = "/incluir")
    public void incluirInformacao(@RequestBody Usuario produto) {
        service.save(produto);
    }

    @GetMapping(value = "/usuario/{id}")
    public Usuario buscarUsuario(@PathVariable Integer id) {
        return service.get(id, "Usuário não encontrado");
    }
}
