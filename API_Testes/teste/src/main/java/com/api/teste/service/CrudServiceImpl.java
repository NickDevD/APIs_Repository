package com.api.teste.service;

import com.api.teste.model.Comida;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CrudServiceImpl implements CrudService{

    List<Comida> comida;

    public CrudServiceImpl(){
        comida = new ArrayList<>();
    }

    @Override
    public void criar(Comida c) {
        comida.add(c);
    }

    @Override
    public void excluir(Comida comida) {

    }

    @Override
    public List<Comida> listar() {
        return List.of();
    }

    @Override
    public void excluir() {
        comida.removeIf(comida -> comida.getDataExpiracao().isAfter(LocalDate.now()));
        }
    }

