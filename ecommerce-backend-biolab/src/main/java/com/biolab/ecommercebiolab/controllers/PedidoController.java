package com.biolab.ecommercebiolab.controllers;

import com.biolab.ecommercebiolab.DTOs.PedidoDTO;
import com.biolab.ecommercebiolab.services.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pedido")
public class PedidoController {

    private final PedidoService service;
    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> saveOrder(@RequestBody PedidoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criarPedido(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delOrder(@PathVariable long id) {
        service.deletarPedido(id);
        return ResponseEntity.ok("Apagado com sucesso!!");
    }

}
