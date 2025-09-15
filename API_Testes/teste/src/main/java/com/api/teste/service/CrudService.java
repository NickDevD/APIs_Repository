package com.api.teste.service;

import com.api.teste.model.Comida;

import java.time.LocalDate;
import java.util.List;

public interface CrudService {

    void criar(Comida comida);

    List<Comida> listar();

    void excluirVencidos();

    void atualizar(Comida comida);
}
