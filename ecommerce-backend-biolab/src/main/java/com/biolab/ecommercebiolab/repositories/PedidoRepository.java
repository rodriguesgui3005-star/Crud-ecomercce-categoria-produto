package com.biolab.ecommercebiolab.repositories;

import com.biolab.ecommercebiolab.entities.Pedido;
import com.biolab.ecommercebiolab.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
