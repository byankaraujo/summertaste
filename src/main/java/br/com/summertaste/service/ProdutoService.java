package br.com.summertaste.service;

import br.com.summertaste.model.Produto;
import br.com.summertaste.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto cadastrarProduto(Produto produto) {

        if (produto == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo");
        }

        if (produto.getDataCadastroProduto() == null) {
            produto.setDataCadastroProduto(LocalDate.now());
        }

        return produtoRepository.save(produto);
    }

    public Produto buscarPorId(Long idProduto) {
        return produtoRepository.buscarPorId(idProduto);
    }

    public List<Produto> listarTodos() {
        return produtoRepository.listarTodos();
    }

    public List<Produto> buscarProduto(String nome, Long id) {
        String nomeFiltro = (nome == null || nome.trim().isEmpty()) ? null : nome;
        return produtoRepository.buscarProduto(nome, id);
    }

}
