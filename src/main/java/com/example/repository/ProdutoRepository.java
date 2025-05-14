package com.example.repository;

import com.example.model.Produto;
import java.util.HashMap;
import java.util.Map;

public class ProdutoRepository {
    private Map<String, Produto> produtos = new HashMap<>();

    public void salvar(Produto produto) {
        produtos.put(produto.getCodigo(), produto);
    }

    public Produto buscar(String codigo) {
        return produtos.get(codigo);
    }

    public void alterarPreco(String codigo, double novoPreco) {
        Produto produto = produtos.get(codigo);
        if (produto != null) {
            produto.setPreco(novoPreco);
        }
    }
}
