package com.biolab.ecommercebiolab.entities;

import com.biolab.ecommercebiolab.entities.enums.StatusPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
// substitui os getters e setters
@Data
// substitui o construtor com todos os argumentos
@AllArgsConstructor
// substitui o construtor vazio
@NoArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Instant momento;
    private StatusPedido status;
    @ManyToOne
    private Usuario cliente;
    @OneToOne(mappedBy = "pedido" , cascade = CascadeType.ALL)
    private Pagamento pagamento;

}
