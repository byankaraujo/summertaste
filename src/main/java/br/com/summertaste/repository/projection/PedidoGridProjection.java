package br.com.summertaste.repository.projection;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface PedidoGridProjection {

    Long getPedidoId();
    LocalDate getPedidoData();
    Long getClienteId();
    String getClienteNome();
    String getClienteCpf();
    Long getProdutoId();
    String getProdutoNome();
    BigDecimal getProdutoValor();
    BigDecimal getProdutoDesconto();
    Integer getProdutoQtd();
}
