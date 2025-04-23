package com.example.Atividadeavali.controller;


import com.example.Atividadeavali.DTO.UsuarioDTO;
import com.example.Atividadeavali.entity.Usuario;
import com.example.Atividadeavali.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:5500")
public class UsuarioController {


    @Autowired
    private UsuarioService usuarioService;


    @PostMapping
    public ResponseEntity<UsuarioDTO> created(@RequestBody UsuarioDTO usuarioDTO){
        UsuarioDTO usuario = usuarioService.sateDTO(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }


    @GetMapping
    public ResponseEntity<List<Usuario>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getById(@PathVariable Long id){
        Optional<UsuarioDTO> usuarioDTO= usuarioService.getById(id);
        if (usuarioDTO.isPresent()){
            return ResponseEntity.ok(usuarioDTO.get());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
