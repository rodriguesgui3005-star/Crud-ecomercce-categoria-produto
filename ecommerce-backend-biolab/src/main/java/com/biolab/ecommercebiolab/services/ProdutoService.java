package com.biolab.ecommercebiolab.services;

import com.biolab.ecommercebiolab.DTOs.CategoriaDTO;
import com.biolab.ecommercebiolab.DTOs.ProdutoDTO;
import com.biolab.ecommercebiolab.entities.Categoria;
import com.biolab.ecommercebiolab.entities.Produto;
import com.biolab.ecommercebiolab.repositories.CategoriaRepository;
import com.biolab.ecommercebiolab.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;
    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public String criar(ProdutoDTO dto){
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        produto.setImgUrl(dto.getImgUrl());
        Categoria cat = categoriaRepository.getReferenceById(dto.getIdCategoria());
        produto.getCategorias().add(cat);
        produtoRepository.save(produto);
        return "Produto salvo com sucesso!";
    }

    public List<ProdutoDTO> mostrarProdutos(){
        return produtoRepository.findAll().stream()
                .map(produto -> new ProdutoDTO(produto.getId(),produto.getNome(), produto.getDescricao(),
                        produto.getPreco(),produto.getImgUrl(), produto.getId()
                ))
                .toList();
    }

    public ProdutoDTO buscarProdutoPorId(long id){
        Produto produto = produtoRepository.findById(id).orElseThrow();
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setNome(produto.getNome());
        produtoDTO.setId(produto.getId());
        produtoDTO.setDescricao(produto.getDescricao());
        produtoDTO.setPreco(produto.getPreco());
        produtoDTO.setImgUrl(produto.getImgUrl());
        return produtoDTO;
    }

    public String editarProduto(long id, ProdutoDTO dto){
        Produto editarProd = produtoRepository.findById(id).orElseThrow();
        editarProd.setNome(dto.getNome());
        editarProd.setDescricao(dto.getDescricao());
        editarProd.setPreco(dto.getPreco());
        editarProd.setImgUrl(dto.getImgUrl());
        produtoRepository.save(editarProd);
        return "Produto editado com sucesso";
    }

    public String apagarProduto(long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isEmpty()){
            return "produto não encontrado";
        } else {
            produtoRepository.deleteById(id);
            return "produto excluído com sucesso";
        }
    }
}

