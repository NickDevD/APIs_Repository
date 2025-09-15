package com.api.teste.service;

import com.api.teste.model.Comida;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CrudServiceImpl implements CrudService{

    List<Comida> comidas;

    public CrudServiceImpl(){
        comidas = new ArrayList<>();
    }

    @Override
    public void criar(Comida c) {
        comidas.add(c);
    }


    @Override
    public List<Comida> listar() {
        return new ArrayList<>(comidas);
    }
    

    @Override
    public void excluirVencidos() {
        comidas.removeIf(comida -> comida.getDataExpiracao().isBefore(LocalDate.now()));

    }

    @Override
    public void atualizar(Comida co) {
        Comida coAtualizar = co;
        coAtualizar.setNome(co.getNome());
        coAtualizar.setDataExpiracao(co.getDataExpiracao());
    }

}

