package com.biolab.ecommercebiolab.controllers;

import com.biolab.ecommercebiolab.DTOs.UsuarioDTO;
import com.biolab.ecommercebiolab.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    private final UsuarioService service;
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody UsuarioDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarUsuario(dto));
    }
}
