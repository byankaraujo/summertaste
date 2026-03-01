package br.com.summertaste.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUTO_ID")
    private Long idProduto;

    @Column(name = "PRODUTO_NOME", nullable = false, length = 150)
    private String nomeProduto;

    @Column(name = "PRODUTO_DESCRICAO", nullable = false, length = 255)
    private String descricaoProduto;

    @Column(name = "PRODUTO_VALOR", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorProduto;

    @Column(name = "PRODUTO_QTD_ESTOQUE", nullable = false)
    private Integer quantidadeEstoque;

    @Column(name = "PRODUTO_DATA_CADASTRO", nullable = false)
    private LocalDate dataCadastroProduto;

    public Produto() {
    }

    // Getters e Setters

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long pIdProduto) {
        idProduto = pIdProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String pNomeProduto) {
        if (pNomeProduto == null || pNomeProduto.isBlank()) {
            throw new IllegalArgumentException("Nome do produto não pode ser nulo ou vazio.");
        }
        nomeProduto = pNomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String pDescricaoProduto) {
        if (pDescricaoProduto == null || pDescricaoProduto.isBlank()) {
            throw new IllegalArgumentException("Descrição do produto não pode ser nula ou vazia.");
        }
        descricaoProduto = pDescricaoProduto;
    }

    public BigDecimal getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(BigDecimal pValorProduto) {
        if (pValorProduto == null || pValorProduto.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Valor do produto não pode ser nulo ou negativo.");
        }
        valorProduto = pValorProduto;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer pQuantidadeEstoque) {
        if (pQuantidadeEstoque == null || pQuantidadeEstoque < 0) {
            throw new IllegalArgumentException("Quantidade em estoque não pode ser nula ou negativa.");
        }
        quantidadeEstoque = pQuantidadeEstoque;
    }

    public LocalDate getDataCadastroProduto() {
        return dataCadastroProduto;
    }

    public void setDataCadastroProduto(LocalDate pDataCadastroProduto) {
        if (pDataCadastroProduto == null) {
            throw new IllegalArgumentException("Data de cadastro do produto não pode ser nula.");
        }
        dataCadastroProduto = pDataCadastroProduto;
    }
}