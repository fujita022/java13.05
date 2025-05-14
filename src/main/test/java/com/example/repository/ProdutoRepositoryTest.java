package com.example.repository;

import com.example.model.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoRepositoryTest {

    private ProdutoRepository produtoRepository;

    @BeforeEach
    void setUp() {
        produtoRepository = new ProdutoRepository();
    }

    @Test
    void testSalvarProduto() {
        Produto produto = new Produto("Produto X", 500.0, "005");
        produtoRepository.salvar(produto);

        Produto produtoBuscado = produtoRepository.buscar("005");
        assertNotNull(produtoBuscado);
        assertEquals("Produto X", produtoBuscado.getNome());
    }

    @Test
    void testAlterarPrecoProduto() {
        Produto produto = new Produto("Produto Y", 600.0, "006");
        produtoRepository.salvar(produto);

        produtoRepository.alterarPreco("006", 650.0);
        Produto produtoBuscado = produtoRepository.buscar("006");

        assertEquals(650.0, produtoBuscado.getPreco());
    }
}
