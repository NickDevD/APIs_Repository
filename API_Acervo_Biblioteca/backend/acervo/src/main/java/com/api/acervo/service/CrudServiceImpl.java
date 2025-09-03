package com.api.acervo.service;

import com.api.acervo.model.itemDeBiblioteca;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CrudServiceImpl implements CrudService{

    Map<Integer, itemDeBiblioteca> items;

    public CrudServiceImpl(){
        items = new HashMap<>();
    }

    @Override
    public void criar(itemDeBiblioteca item){
        items.put(item.getRegistro(), item);
    }

    @Override
    public void deletar(Integer registro){
        items.remove(registro);
    }

    @Override
    public List<itemDeBiblioteca> listar(){
        return new ArrayList<>(items.values());
    }


}
