package com.biolab.ecommercebiolab.DTOs;

import com.biolab.ecommercebiolab.entities.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {
    private long id;
    private String nome;

    public  CategoriaDTO(String nome) {
        this.nome = nome;
    }
}
