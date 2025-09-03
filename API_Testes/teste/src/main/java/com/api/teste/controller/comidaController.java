package com.api.teste.controller;

import com.api.teste.model.Comida;
import com.api.teste.service.CrudServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class comidaController {

    private final CrudServiceImpl crud;

    public comidaController(CrudServiceImpl crud) {
        this.crud = crud;
    }

    @PostMapping("/criar")
    public ResponseEntity<Comida> criar(@RequestBody Comida comida){
        crud.criar(comida);
        return ResponseEntity.status(201).body(comida);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Comida>> listar(){
        crud.listar();
        return ResponseEntity.status(200).body(crud.listar());
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<Void> deletar(){
        crud.excluir();
        return ResponseEntity.status(204).build();
    }

}
