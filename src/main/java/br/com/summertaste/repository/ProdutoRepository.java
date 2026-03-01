package br.com.summertaste.repository;

import br.com.summertaste.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query(
            value = "SELECT * FROM PRODUTO WHERE PRODUTO_ID = :idProduto",
            nativeQuery = true
    )
    Produto buscarPorId(@Param("idProduto") Long idProduto);

    @Query(
            value = "SELECT * FROM PRODUTO ORDER BY PRODUTO_NOME",
            nativeQuery = true
    )
    List<Produto> listarTodos();

    @Query(
            value = "SELECT * FROM PRODUTO WHERE (:nome IS NULL OR PRODUTO_NOME LIKE %:nome%) AND (:id IS NULL OR PRODUTO_ID = :id)",
            nativeQuery = true
    )
    List<Produto> buscarProduto(@Param("nome") String nome, @Param("id") Long id);

    @Query(
            value = """
        UPDATE PRODUTO
        SET PRODUTO_QTD_ESTOQUE = PRODUTO_QTD_ESTOQUE - :quantidade
        WHERE PRODUTO_ID = :idProduto
    """,
            nativeQuery = true
    )
    void atualizarEstoque(
            @Param("idProduto") Long idProduto,
            @Param("quantidade") Integer quantidade
    );
}
