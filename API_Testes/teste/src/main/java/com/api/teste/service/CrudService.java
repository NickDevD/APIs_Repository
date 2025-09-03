package com.api.teste.service;

import com.api.teste.model.Comida;

import java.time.LocalDate;
import java.util.List;

public interface CrudService {

    public void criar(Comida comida);

    public void excluir(LocalDate dataExpiracao);

    public List<Comida> listar();
}
