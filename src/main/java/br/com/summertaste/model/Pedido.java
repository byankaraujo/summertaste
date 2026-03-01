package br.com.summertaste.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "PEDIDO")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PEDIDO_ID")
    private Long idPedido;

    @Column(name = "CLIENTE_ID", nullable = false)
    private Long idCliente;

    @Column(name = "PEDIDO_DATA", nullable = false)
    private LocalDate dataPedido;

    public Pedido() {
    }

    // Getters e Setters

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long pIdPedido) {
        idPedido = pIdPedido;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long pIdCliente) {
        if (pIdCliente == null) {
            throw new IllegalArgumentException("Cliente do pedido não pode ser nulo");
        }
        idCliente = pIdCliente;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate pDataPedido) {
        if (pDataPedido == null) {
            throw new IllegalArgumentException("Data do pedido não pode ser nula");
        }
        dataPedido = pDataPedido;
    }
}
