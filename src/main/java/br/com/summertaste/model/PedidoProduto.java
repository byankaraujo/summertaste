package br.com.summertaste.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "PEDIDO_PRODUTO")
public class PedidoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PEDIDO_PRODUTO_ID")
    private Long idPedidoProduto;

    @Column(name = "PEDIDO_ID", nullable = false)
    private Long idPedido;

    @Column(name = "PRODUTO_ID", nullable = false)
    private Long idProduto;

    @Column(name = "PRODUTO_VALOR", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorProduto;

    @Column(name = "PRODUTO_QTD", nullable = false)
    private Integer quantidadeProduto;

    @Column(name = "PRODUTO_DESCONTO", nullable = false, precision = 10, scale = 2)
    private BigDecimal descontoProduto;

    public PedidoProduto() {
    }

    // Getters e Setters

    public Long getIdPedidoProduto() {
        return idPedidoProduto;
    }

    public void setIdPedidoProduto(Long pIdPedidoProduto) {
        idPedidoProduto = pIdPedidoProduto;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long pIdPedido) {
        if (pIdPedido == null) {
            throw new IllegalArgumentException("Pedido não pode ser nulo");
        }
        idPedido = pIdPedido;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long pIdProduto) {
        if (pIdProduto == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo");
        }
        idProduto = pIdProduto;
    }

    public BigDecimal getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(BigDecimal pValorProduto) {
        if (pValorProduto == null || pValorProduto.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Valor do produto inválido");
        }
        valorProduto = pValorProduto;
    }

    public Integer getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(Integer pQuantidadeProduto) {
        if (pQuantidadeProduto == null || pQuantidadeProduto <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }
        quantidadeProduto = pQuantidadeProduto;
    }

    public BigDecimal getDescontoProduto() {
        return descontoProduto;
    }

    public void setDescontoProduto(BigDecimal pDescontoProduto) {
        if (pDescontoProduto == null || pDescontoProduto.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Desconto inválido");
        }
        descontoProduto = pDescontoProduto;
    }
}
