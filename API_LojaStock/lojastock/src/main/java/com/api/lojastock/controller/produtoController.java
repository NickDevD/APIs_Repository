package com.api.lojastock.controller;

import com.api.lojastock.model.Produto;
import com.api.lojastock.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class produtoController {

    private final ProdutoService produtoService;

    public produtoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @PostMapping("/criar")
    public ResponseEntity<Produto> criar(@RequestBody Produto produto){
        produtoService.criar(produto);
        return ResponseEntity.status(201).body(produto);
    }
}
