package br.com.summertaste.controller;

import br.com.summertaste.model.Pedido;
import br.com.summertaste.repository.projection.PedidoGridProjection;
import br.com.summertaste.service.PedidoService;
import br.com.summertaste.service.dto.CriarPedidoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class ControladorPedido {

    private final PedidoService pedidoService;

    public ControladorPedido(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody CriarPedidoDTO dto) {
        Pedido pedido = pedidoService.criarPedido(dto.getCpfCliente(), dto.getDataPedido(), dto.getItens());
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<PedidoGridProjection>> buscarPedido(@RequestParam(required = false) Long idPedido, @RequestParam(required = false) Long idProduto, @RequestParam(required = false) String cpfCliente, @RequestParam(required = false) LocalDate dtInicio, @RequestParam(required = false) LocalDate dtFim) {
        return ResponseEntity.ok(pedidoService.buscarPedido(idPedido, idProduto, cpfCliente, dtInicio, dtFim));
    }
}
