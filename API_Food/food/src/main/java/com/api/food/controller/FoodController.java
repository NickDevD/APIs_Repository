package com.api.food.controller;

import com.api.food.model.Food;
import com.api.food.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FoodController {

    @Autowired
    private final CrudService service;

    public FoodController(CrudService service){

        this.service = service;
    }

    @PostMapping("/criar")
    public ResponseEntity<Food> criar(@RequestBody Food food){
        service.criar(food);
        return ResponseEntity.status(201).body(food);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Food> atualizar(@PathVariable Long id, @RequestBody Food food){
        food.setId(id);
        service.atualizar(food);
        return ResponseEntity.status(200).body(food);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Food>> listar(){
        service.listar();
        return ResponseEntity.status(200).body(service.listar());
    }
}
