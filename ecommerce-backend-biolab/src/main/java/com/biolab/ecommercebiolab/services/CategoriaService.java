package com.biolab.ecommercebiolab.services;

import com.biolab.ecommercebiolab.DTOs.CategoriaDTO;
import com.biolab.ecommercebiolab.DTOs.ProdutoDTO;
import com.biolab.ecommercebiolab.entities.Categoria;
import com.biolab.ecommercebiolab.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService{

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public String criarCategoria(CategoriaDTO dto){
        Categoria categoria = new Categoria();
        categoria.setNome(dto.getNome());
        categoriaRepository.save(categoria);
        return "Categoria criada com sucesso!";

    }

    public List<CategoriaDTO> mostrarCategoria(){
        return categoriaRepository.findAll().stream()
                .map(categoria -> new CategoriaDTO(categoria.getId(), categoria.getNome()
                ))
                .toList();

    }

    public CategoriaDTO CategoriaPorId(long id){
        Categoria categoria = categoriaRepository.findById(id).orElseThrow();
        return new CategoriaDTO(categoria.getId(), categoria.getNome());
    }

    public String deletarCategoria(long id){
        categoriaRepository.deleteById(id);
        return "Categoria removida com sucesso!";
    }

    public String atualizarCategoria(long id, ProdutoDTO produtoDTO){
        Categoria categoria = categoriaRepository.findById(id).orElseThrow();
        categoria.setId(produtoDTO.getId());
        categoria.setNome(produtoDTO.getNome());
        categoriaRepository.save(categoria);
        return "Categoria atualizada com sucesso!";
    }

    public String alterarCategoria(long id, CategoriaDTO dto){
        Categoria categoria = categoriaRepository.findById(id).orElseThrow();
        categoria.setNome(dto.getNome());
        categoriaRepository.save(categoria);
        return "Categoria alterada com sucesso!";
    }
}
