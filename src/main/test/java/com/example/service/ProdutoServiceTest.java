package com.example.service;

import com.example.model.Produto;
import com.example.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoServiceTest {

    private ProdutoService produtoService;
    private ProdutoRepository produtoRepository;

    @BeforeEach
    void setUp() {
        produtoRepository = new ProdutoRepository();
        produtoService = new ProdutoService(produtoRepository);
    }

    @Test
    void testCadastrarProduto() {
        produtoService.cadastrarProduto("Produto A", 100.0, "001");
        Produto produto = produtoRepository.buscar("001");

        assertNotNull(produto);
        assertEquals("Produto A", produto.getNome());
        assertEquals(100.0, produto.getPreco());
    }

    @Test
    void testAlterarPrecoProduto() {
        produtoService.cadastrarProduto("Produto B", 200.0, "002");
        produtoService.alterarPreco("002", 250.0);

        Produto produto = produtoRepository.buscar("002");

        assertNotNull(produto);
        assertEquals(250.0, produto.getPreco());
    }

    @Test
    void testBuscarProduto() {
        produtoService.cadastrarProduto("Produto C", 300.0, "003");
        Produto produto = produtoService.buscarProduto("003");

        assertNotNull(produto);
        assertEquals("Produto C", produto.getNome());
    }
}
