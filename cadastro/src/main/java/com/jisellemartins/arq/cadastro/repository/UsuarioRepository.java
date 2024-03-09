package com.jisellemartins.arq.cadastro.repository;

import com.jisellemartins.arq.cadastro.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
