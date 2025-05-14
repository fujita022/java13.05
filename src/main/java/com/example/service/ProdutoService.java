package com.example.service;

import com.example.model.Produto;
import com.example.repository.ProdutoRepository;

public class ProdutoService {
    private ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public void cadastrarProduto(String nome, double preco, String codigo) {
        Produto produto = new Produto(nome, preco, codigo);
        repository.salvar(produto);
    }

    public void alterarPreco(String codigo, double novoPreco) {
        repository.alterarPreco(codigo, novoPreco);
    }

    public Produto buscarProduto(String codigo) {
        return repository.buscar(codigo);
    }
}
