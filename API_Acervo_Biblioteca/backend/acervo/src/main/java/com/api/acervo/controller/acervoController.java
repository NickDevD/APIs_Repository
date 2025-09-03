package com.api.acervo.controller;

import com.api.acervo.model.Livro;
import com.api.acervo.model.Revista;
import com.api.acervo.model.itemDeBiblioteca;
import com.api.acervo.service.CrudServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class acervoController {

    private final CrudServiceImpl crudService;

    public acervoController(CrudServiceImpl crudService){
        this.crudService = crudService;
    }

    @PostMapping("/criarLivro")
    public ResponseEntity<Livro> criar(@RequestBody Livro livro){
        crudService.criar(livro);
        return ResponseEntity.status(201).body(livro);
    }

    @PostMapping("/criarRevista")
    public ResponseEntity<Revista> criar(@RequestBody Revista revista){
        crudService.criar(revista);
        return ResponseEntity.status(201).body(revista);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<itemDeBiblioteca>> listar(){
        crudService.listar();
        return ResponseEntity.status(200).body(crudService.listar());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletar(@RequestParam int registro){
        crudService.deletar(registro);
        return ResponseEntity.status(204).build();
    }
}
