package com.biolab.ecommercebiolab.DTOs;

import com.biolab.ecommercebiolab.entities.Usuario;
import com.biolab.ecommercebiolab.entities.enums.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    private long id;
    private Instant momento;
    private StatusPedido status;
    private long idCliente;

    public PedidoDTO(long idCliente) {
        this.idCliente = idCliente;
    }
}