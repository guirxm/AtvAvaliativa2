package com.example.Atividadeavali.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)



    private long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String username;
    private String senha;
    @Column(unique = true)
    private String cpf;
    private Long dataNascimento;     

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private Set<Usuario> usuario;


    public Usuario(long id, String nome, String sobrenome, String cpf, String email, String username, String senha, Long dataNascimento){
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.username = username;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
    }
}
