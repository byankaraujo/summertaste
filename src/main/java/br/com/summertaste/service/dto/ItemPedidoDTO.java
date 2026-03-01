package br.com.summertaste.service.dto;

import java.math.BigDecimal;

public class ItemPedidoDTO {

    private Long idProduto;
    private Integer quantidade;
    private BigDecimal desconto;

    public ItemPedidoDTO() {
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }
}
