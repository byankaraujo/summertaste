package br.com.summertaste.repository;

import br.com.summertaste.model.Pedido;
import br.com.summertaste.repository.projection.PedidoGridProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query(
            value = """
        SELECT
            p.PEDIDO_ID as pedidoId,
            p.PEDIDO_DATA as pedidoData,
            p.CLIENTE_ID as clienteId,
            c.CLIENTE_NOME as clienteNome,
            c.CLIENTE_CPF as clienteCpf,
            pr.PRODUTO_ID as produtoId,
            pr.PRODUTO_NOME as produtoNome,
            pp.PRODUTO_VALOR as produtoValor,
            pp.PRODUTO_DESCONTO as produtoDesconto,
            pp.PRODUTO_QTD as produtoQtd
        FROM PEDIDO p
        JOIN PEDIDO_PRODUTO pp ON p.PEDIDO_ID = pp.PEDIDO_ID
        JOIN CLIENTE c ON p.CLIENTE_ID = c.CLIENTE_ID
        JOIN PRODUTO pr ON pp.PRODUTO_ID = pr.PRODUTO_ID
        WHERE (:idProduto IS NULL OR pp.PRODUTO_ID = :idProduto)
          AND (:idPedido IS NULL OR p.PEDIDO_ID = :idPedido)
          AND (:cpfCliente IS NULL OR c.CLIENTE_CPF = :cpfCliente)
          AND (
                (:dtInicio IS NULL OR :dtFim IS NULL)
                OR p.PEDIDO_DATA BETWEEN :dtInicio AND :dtFim
              )
        ORDER BY p.PEDIDO_ID
    """,
            nativeQuery = true
    )
    List<PedidoGridProjection> buscarPedido(@Param("idPedido") Long idPedido, @Param("idProduto") Long idProduto, @Param("cpfCliente") String cpfCliente, @Param("dtInicio") LocalDate dtInicio, @Param("dtFim") LocalDate dtFim);
}
