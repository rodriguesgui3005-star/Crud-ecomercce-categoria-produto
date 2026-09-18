package com.biolab.ecommercebiolab.services;

import com.biolab.ecommercebiolab.DTOs.PedidoDTO;
import com.biolab.ecommercebiolab.entities.Pedido;
import com.biolab.ecommercebiolab.entities.Usuario;
import com.biolab.ecommercebiolab.entities.enums.StatusPedido;
import com.biolab.ecommercebiolab.repositories.PedidoRepository;
import com.biolab.ecommercebiolab.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final UsuarioRepository usuarioRepository;
    public PedidoService(PedidoRepository pedidoRepository, UsuarioRepository usuarioRepository) {
        this.pedidoRepository = pedidoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public String criarPedido(PedidoDTO dto){
        Usuario cliente = usuarioRepository.findById(dto.getIdCliente())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setMomento(Instant.now());
        pedido.setStatus(StatusPedido.AGUARDANDO_PAGAMENTO);
        pedidoRepository.save(pedido);
        return "Pedido criado com sucesso";
    }

    public String deletarPedido(long id){
        Pedido pedido = pedidoRepository.findById(id).orElseThrow();
        pedidoRepository.deleteById(id);
        return "Excluido com sucesso!!";
    }
}
