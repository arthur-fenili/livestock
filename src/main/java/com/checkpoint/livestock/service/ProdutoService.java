package com.checkpoint.livestock.service;

import com.checkpoint.livestock.dto.request.ProdutoRequest;
import com.checkpoint.livestock.dto.response.ProdutoResponse;
import com.checkpoint.livestock.model.Armazem;
import com.checkpoint.livestock.model.Produto;
import com.checkpoint.livestock.repository.ArmazemRepository;
import com.checkpoint.livestock.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ArmazemRepository armazemRepository;

    public ProdutoService(ProdutoRepository produtoRepository, ArmazemRepository armazemRepository) {
        this.produtoRepository = produtoRepository;
        this.armazemRepository = armazemRepository;
    }

    public void cadastrarProduto(ProdutoRequest dto) {
        Armazem armazem = armazemRepository.findById(dto.getIdArmazem())
                .orElseThrow(() -> new RuntimeException("Armazém não encontrado"));

        Produto produto = new Produto();
        produto.setNomeProduto(dto.getNomeProduto());
        produto.setQuantidade(dto.getQuantidade());
        produto.setPrecoCusto(dto.getPrecoCusto());
        produto.setCategoria(dto.getCategoria());
        produto.setArmazem(armazem);

        produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public ProdutoResponse buscarPorId(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return toResponse(produto);
    }

    public List<ProdutoResponse> listarProdutosPorCategoria() {
        return produtoRepository.findAllByOrderByCategoriaAsc().stream()
                .map(this::toResponse)
                .toList();
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    public void atualizarProduto(Long id, ProdutoRequest dto) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Armazem armazem = armazemRepository.findById(dto.getIdArmazem())
                .orElseThrow(() -> new RuntimeException("Armazém não encontrado"));

        produto.setNomeProduto(dto.getNomeProduto());
        produto.setQuantidade(dto.getQuantidade());
        produto.setPrecoCusto(dto.getPrecoCusto());
        produto.setCategoria(dto.getCategoria());
        produto.setArmazem(armazem);

        produtoRepository.save(produto);
    }

    private ProdutoResponse toResponse(Produto produto) {
        return new ProdutoResponse(
                produto.getId(),
                produto.getNomeProduto(),
                produto.getQuantidade(),
                produto.getPrecoCusto(),
                produto.getCategoria(),
                produto.getArmazem().getNomeArmazem()
        );
    }
}
