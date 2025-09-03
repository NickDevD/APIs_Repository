package com.api.acervo.service;

import com.api.acervo.model.itemDeBiblioteca;

import java.util.List;

public interface CrudService {

    public void criar(itemDeBiblioteca item);

    public void deletar(Integer registro);

    public List<itemDeBiblioteca> listar();
}
