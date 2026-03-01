package br.com.summertaste.controller;

import br.com.summertaste.model.Cliente;
import br.com.summertaste.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ControladorCliente {

    private final ClienteService clienteService;

    public ControladorCliente(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
        Cliente clienteSalvo = clienteService.cadastrarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        return ResponseEntity.ok(clienteService.listarTodos());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Cliente>> buscarCliente(@RequestParam(required = false) String nome, @RequestParam(required = false) String cpf) {
        return ResponseEntity.ok(clienteService.buscarCliente(nome, cpf));
    }

    @GetMapping("/clientes/cpf/{cpf}")
    public ResponseEntity<Cliente> buscarClientePorCPF(@RequestParam(required = true) String cpf) {
        return ResponseEntity.ok(clienteService.buscarClientePorCPF( cpf));
    }
}
