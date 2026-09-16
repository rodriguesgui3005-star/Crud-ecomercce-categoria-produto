package com.biolab.ecommercebiolab.DTOs;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {
    private long id;
    @NotBlank
    private String nome;
    private String descricao;
    @NotNull
    private double preco;
    private String imgUrl;
    private  long idCategoria;

    public ProdutoDTO(String nome, double preco, String descricao, String imgUrl, long idCategoria) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.imgUrl = imgUrl;
        this.idCategoria = idCategoria;
    }
}
