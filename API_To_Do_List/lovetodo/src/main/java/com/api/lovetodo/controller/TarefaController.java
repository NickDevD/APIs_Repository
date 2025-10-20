package com.api.lovetodo.controller;

import com.api.lovetodo.model.Tarefa;
import com.api.lovetodo.service.TarefaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lovetodo")
public class TarefaController {

    private final TarefaService tarefaService;


    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping("/criar")
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody Tarefa tarefa){
        Tarefa novaTarefa = tarefaService.criarTarefa(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTarefa);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Tarefa>> listarTarefas(){
        List<Tarefa> itens = tarefaService.listarTarefas();
        return ResponseEntity.status(HttpStatus.OK).body(itens);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirTarefa(@PathVariable Long id){
        tarefaService.deleteTarefa(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
