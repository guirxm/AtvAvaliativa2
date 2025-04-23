package com.example.Atividadeavali.service;

import com.example.Atividadeavali.DTO.UsuarioDTO;
import com.example.Atividadeavali.entity.Usuario;
import com.example.Atividadeavali.repository.UsuarioRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UsuarioService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario fromDTO(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());
        usuario.setNome(usuario.getNome());
        usuario.setSobrenome(usuario.getSobrenome());
        usuario.setCpf(usuario.getCpf());
        usuario.setDataNascimento(usuario.getDataNascimento());
        usuario.setEmail(usuario.getEmail());
        usuario.setUsername(usuario.getUsername());
        usuario.setSenha(usuario.getSenha());

        return usuario;
    }

    public UsuarioDTO toDTO(Usuario usuario){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuarioDTO.getId());
        usuarioDTO.setNome(usuarioDTO.getNome());
        usuarioDTO.setSobrenome(usuarioDTO.getSobrenome());
        usuarioDTO.setCpf(usuarioDTO.getCpf());
        usuarioDTO.setDataNascimento(usuarioDTO.getDataNascimento());
        usuarioDTO.setEmail(usuarioDTO.getEmail());
        usuarioDTO.setUsername(usuarioDTO.getUsername());
        usuarioDTO.setSenha(usuarioDTO.getSenha());

        return usuarioDTO;
    }

    public List<Usuario> getAll(){ return usuarioRepository.findAll();}


    public Optional<UsuarioDTO> getById(Long id){
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isPresent()){
            return Optional.of(this.toDTO(optionalUsuario.get()));
        }else {
            return  Optional.empty();
        }
    }

    public UsuarioDTO sateDTO(UsuarioDTO usuarioDTO){
        Usuario usuario = this.fromDTO(usuarioDTO);
        Usuario usuarioBd = usuarioRepository.save(usuario);
        return this.toDTO(usuarioBd);
    }

}
