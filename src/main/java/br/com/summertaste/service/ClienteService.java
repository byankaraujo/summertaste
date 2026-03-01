package br.com.summertaste.service;

import br.com.summertaste.model.Cliente;
import br.com.summertaste.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente cadastrarCliente(Cliente cliente) {

        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }

        if (cliente.getCpfCliente() == null || cliente.getCpfCliente().length() != 11) {
            throw new IllegalArgumentException("CPF inválido");
        }

        if (cliente.getDataCadastroCliente() == null) {
            cliente.setDataCadastroCliente(LocalDate.now());
        }

        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.listarTodos();
    }

    public List<Cliente> buscarCliente(String nome, String cpf) {

        String nomeFiltro = (nome == null || nome.isBlank()) ? null : nome;
        String cpfFiltro  = (cpf == null || cpf.isBlank()) ? null : cpf;

        return clienteRepository.buscarCliente(nomeFiltro, cpfFiltro);
    }

    public Cliente buscarClientePorCPF(String cpf) {
        if(cpf == null || cpf.trim().isEmpty())
            throw new NullPointerException("O CPF não pode ser nulo.");

        return clienteRepository.buscarClientePorCPF(cpf);
    }
}
