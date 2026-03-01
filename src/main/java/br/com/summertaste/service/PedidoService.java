package br.com.summertaste.service;

import br.com.summertaste.model.Cliente;
import br.com.summertaste.model.Pedido;
import br.com.summertaste.model.PedidoProduto;
import br.com.summertaste.model.Produto;
import br.com.summertaste.repository.ClienteRepository;
import br.com.summertaste.repository.PedidoProdutoRepository;
import br.com.summertaste.repository.PedidoRepository;
import br.com.summertaste.repository.ProdutoRepository;
import br.com.summertaste.repository.projection.PedidoGridProjection;
import br.com.summertaste.service.dto.ItemPedidoDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final PedidoProdutoRepository pedidoProdutoRepository;
    private final ProdutoRepository produtoRepository;
    private final ClienteRepository clienteRepository;

    public PedidoService(PedidoRepository pedidoRepository,
                         PedidoProdutoRepository pedidoProdutoRepository,
                         ProdutoRepository produtoRepository, ClienteRepository clienteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoProdutoRepository = pedidoProdutoRepository;
        this.produtoRepository = produtoRepository;
        this.clienteRepository = clienteRepository;
    }

    /**
     * Cria um pedido para um cliente e adiciona os itens
     */
    @Transactional
    public Pedido criarPedido(String cpfCliente, LocalDate dataPedido, List<ItemPedidoDTO> itens) {
    Long idCliente = null;

        if (cpfCliente == null || cpfCliente.trim().isEmpty()) {
            throw new IllegalArgumentException("Selecione o CPF do cliente.");
        }

        Cliente cliente = clienteRepository.buscarClientePorCPF(cpfCliente);

        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado: " + cpfCliente);
        }else{
            idCliente = cliente.getIdCliente();
        }

        if(dataPedido == null)
            throw new IllegalArgumentException("A data do pedido deve ser preenchida");

        if (itens == null || itens.isEmpty()) {
            throw new IllegalArgumentException("Pedido deve conter ao menos um item");
        }

        // 1️⃣ Cria o pedido
        Pedido pedido = new Pedido();
        pedido.setIdCliente(idCliente);
        pedido.setDataPedido(dataPedido);

        pedido = pedidoRepository.save(pedido);

        // 2️⃣ Cria os itens do pedido
        for (ItemPedidoDTO item : itens) {

            Produto produto = produtoRepository.buscarPorId(item.getIdProduto());
            if (produto == null) {
                throw new IllegalArgumentException("Produto não encontrado: " + item.getIdProduto());
            }

            PedidoProduto pedidoProduto = new PedidoProduto();
            pedidoProduto.setIdPedido(pedido.getIdPedido());
            pedidoProduto.setIdProduto(produto.getIdProduto());
            pedidoProduto.setQuantidadeProduto(item.getQuantidade());
            pedidoProduto.setDescontoProduto(item.getDesconto() != null ? item.getDesconto() : BigDecimal.ZERO);
            pedidoProduto.setValorProduto(produto.getValorProduto());

            BigDecimal desconto = item.getDesconto() != null
                    ? item.getDesconto()
                    : BigDecimal.ZERO;

            pedidoProduto.setDescontoProduto(desconto);

            if (produto.getQuantidadeEstoque() < item.getQuantidade()) {
                throw new IllegalArgumentException("Estoque insuficiente para o produto: " + produto.getIdProduto());
            }

            pedidoProdutoRepository.save(pedidoProduto);

            // atualiza estoque
            produto.setQuantidadeEstoque(
                    produto.getQuantidadeEstoque() - item.getQuantidade()
            );
            produtoRepository.save(produto);

        }

        return pedido;
    }

    public List<PedidoGridProjection> buscarPedido(Long idPedido, Long idProduto, String cpfCliente, LocalDate inicio, LocalDate fim) {
        String cpfFiltro  = (cpfCliente == null || cpfCliente.trim().isEmpty()) ? null : cpfCliente;

        return pedidoRepository.buscarPedido(idPedido, idProduto, cpfCliente, inicio, fim);
    }
}
