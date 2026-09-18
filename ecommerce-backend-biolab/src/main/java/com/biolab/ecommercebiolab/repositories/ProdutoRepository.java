package com.biolab.ecommercebiolab.repositories;

import com.biolab.ecommercebiolab.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
