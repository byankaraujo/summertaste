package br.com.summertaste.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLIENTE_ID")
    private Long idCliente;


    @Column(name = "CLIENTE_NOME", nullable = false, length = 150)
    private String nomeCliente;

    @Column(name = "CLIENTE_CPF", nullable = false, unique = true, length = 11)
    private String cpfCliente;

    @Column(name = "CLIENTE_EMAIL", nullable = true, length = 150)
    private String emailCliente;

    @Column(name = "CLIENTE_DATA_CADASTRO", nullable = false)
    private LocalDate dataCadastroCliente;

    public Cliente() {
    }

    // Getters e Setters

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long pIdCliente) {
       idCliente = pIdCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String pNomeCliente) {
        if (pNomeCliente == null || pNomeCliente.isBlank()) {
            throw new IllegalArgumentException("Nome do cliente não pode ser nulo ou vazio.");
        }
        nomeCliente = pNomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String pCpfCliente) {
        if (pCpfCliente == null || pCpfCliente.isBlank()) {
            throw new IllegalArgumentException("O CPF do cliente não pode ser nulo ou vazio.");
        }
        cpfCliente = pCpfCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String pEmailCliente) {
        emailCliente = pEmailCliente;
    }

    public LocalDate getDataCadastroCliente() {
        return dataCadastroCliente;
    }

    public void setDataCadastroCliente(LocalDate pDataCadastroCliente) {
        if (pDataCadastroCliente == null) {
            throw new IllegalArgumentException("Data de cadastro não pode ser nula.");
        }
        dataCadastroCliente = pDataCadastroCliente;
    }
}
