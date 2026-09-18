package com.biolab.ecommercebiolab.services;

import com.biolab.ecommercebiolab.DTOs.PagamentoDTO;
import com.biolab.ecommercebiolab.entities.Pagamento;
import com.biolab.ecommercebiolab.entities.Pedido;
import com.biolab.ecommercebiolab.repositories.PagamentoRepository;
import com.biolab.ecommercebiolab.repositories.PedidoRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class PagamentoService {
    private final PagamentoRepository pagamentoRepository;
    private final PedidoRepository pedidoRepository;
    public PagamentoService(PagamentoRepository pagamentoRepository,
                            PedidoRepository pedidoRepository) {
        this.pagamentoRepository = pagamentoRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public String criarPagamento(PagamentoDTO dto){
        Pedido p = pedidoRepository.findById(dto.getIdPedido()).orElseThrow();
        Pagamento pagamento = new Pagamento();
        pagamento.setMomento(Instant.now());
        pagamento.setPedido(p);
        pagamentoRepository.save(pagamento);
        return "Pagamento Realizado com sucesso";
    }
}
