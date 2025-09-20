package com.api.lovetodo.service;

import com.api.lovetodo.model.Tarefa;
import com.api.lovetodo.repository.TarefaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TarefaService {

    private static final Logger log = LoggerFactory.getLogger(TarefaService.class);
    private final TarefaRepository service;

    public TarefaService(TarefaRepository service){
        this.service = service;
    }


    public void criarTarefa(Tarefa tarefa) {
        if (tarefa.getTitulo() == null || tarefa.getTitulo().isBlank()){
            log.error("Titulo não pode ser vazio");
            throw new RuntimeException("Titulo vazio");
        }else {
            service.save(tarefa);
        }
    }

    public void listarTarefas(){
        service.findAll();
    }

    public Optional<Tarefa> listarTarefasID(Long id){
        return service.findById(id);

    }

    public void deleteTarefa(Long id){
        service.deleteById(id);
    }
}
