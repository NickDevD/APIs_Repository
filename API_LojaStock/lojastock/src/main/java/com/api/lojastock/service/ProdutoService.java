package com.api.lojastock.service;

import com.api.lojastock.model.Produto;
import com.api.lojastock.repository.produtoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService  {

    private final produtoRepository crud;

    public ProdutoService(produtoRepository crud){
        this.crud = crud;
    }

    public void criar(Produto produto){
        crud.save(produto);
    }

}
