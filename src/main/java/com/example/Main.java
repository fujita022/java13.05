package com.example;

import com.example.model.Produto;
import com.example.repository.ProdutoRepository;
import com.example.service.ProdutoService;

public class Main {
    public static void main(String[] args) {
        ProdutoRepository repository = new ProdutoRepository();
        ProdutoService service = new ProdutoService(repository);

        service.cadastrarProduto("Produto A", 100.0, "001");
        service.cadastrarProduto("Produto B", 200.0, "002");

        service.alterarPreco("001", 120.0);

        Produto produto = service.buscarProduto("001");
        System.out.println(produto);
    }
}
