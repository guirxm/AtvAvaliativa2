package com.example.Atividadeavali.DTO;


import com.example.Atividadeavali.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO implements Serializable {

    private long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    private String username;
    private String senha;
    private Long dataNascimento;




    public Usuario toUsuario(){
        return new Usuario(
                this.id,
                this.nome,
                this.sobrenome,
                this.cpf,
                this.email,
                this.username,
                this.senha,
                this.dataNascimento
        );
    }

    public UsuarioDTO fromUsuario(Usuario usuario){
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getSobrenome(),
                usuario.getCpf(),
                usuario.getEmail(),
                usuario.getUsername(),
                usuario.getSenha(),
                usuario.getDataNascimento()

        );
    }
}
