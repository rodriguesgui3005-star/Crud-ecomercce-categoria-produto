package com.biolab.ecommercebiolab.repositories;

import com.biolab.ecommercebiolab.entities.Pagamento;
import com.biolab.ecommercebiolab.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
