package br.com.summertaste.repository;

import br.com.summertaste.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query(
            value = "SELECT * FROM CLIENTE ORDER BY CLIENTE_NOME",
            nativeQuery = true
    )
    List<Cliente> listarTodos();

    @Query(
            value = "SELECT * FROM CLIENTE WHERE (:nome IS NULL OR CLIENTE_NOME LIKE %:nome%) AND (:cpf IS NULL OR CLIENTE_CPF = :cpf)",
            nativeQuery = true
    )
    List <Cliente> buscarCliente(@Param("nome") String nome, @Param("cpf") String cpf);

    @Query(
            value = "SELECT * FROM CLIENTE WHERE (CLIENTE_CPF = :cpf)",
            nativeQuery = true
    )
    Cliente buscarClientePorCPF(@Param("cpf") String cpf);
}

