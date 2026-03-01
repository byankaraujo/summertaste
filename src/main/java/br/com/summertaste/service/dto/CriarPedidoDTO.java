package br.com.summertaste.service.dto;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

public class CriarPedidoDTO {
    // DTO usado para entrada de dados na criação de pedido
    private String cpfCliente;
    private LocalDate dataPedido;
    private List<ItemPedidoDTO> itens;

    public CriarPedidoDTO() {
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public List<ItemPedidoDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoDTO> itens) {
        this.itens = itens;
    }
}
