package com.biolab.ecommercebiolab.controllers;

import com.biolab.ecommercebiolab.DTOs.CategoriaDTO;
import com.biolab.ecommercebiolab.DTOs.ProdutoDTO;
import com.biolab.ecommercebiolab.repositories.CategoriaRepository;
import com.biolab.ecommercebiolab.services.CategoriaService;
import com.biolab.ecommercebiolab.services.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> mostrarCategorias() {
        return ResponseEntity.ok(categoriaService.mostrarCategoria());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> buscarCategoriaId(@PathVariable Long id){
        return ResponseEntity.ok(categoriaService.CategoriaPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoriaDTO> deletarCategoria(@PathVariable Long id){
        return ResponseEntity.ok(categoriaService.CategoriaPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> alterarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO dto){
        return ResponseEntity.ok(categoriaService.alterarCategoria(id,dto));
    }
}
