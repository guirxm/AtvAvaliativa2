package com.example.Atividadeavali.repository;

import com.example.Atividadeavali.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
