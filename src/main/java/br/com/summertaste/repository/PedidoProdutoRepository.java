package br.com.summertaste.repository;

import br.com.summertaste.model.PedidoProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidoProdutoRepository extends JpaRepository<PedidoProduto, Long> {

    @Query(
            value = "SELECT * FROM PEDIDO_PRODUTO WHERE PEDIDO_ID = :idPedido",
            nativeQuery = true
    )
    List<PedidoProduto> listarItensPorPedido(@Param("idPedido") Long idPedido);
}
