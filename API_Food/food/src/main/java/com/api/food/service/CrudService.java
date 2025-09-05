package com.api.food.service;


import com.api.food.Repository.FoodRepository;
import com.api.food.model.Food;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudService {

    private final FoodRepository foodRepository;

    public CrudService(FoodRepository foodRepository){

        this.foodRepository = foodRepository;
    }

    public void criar(Food food){

        foodRepository.save(food);
    }

    public void atualizar(Food food){
        Food find = foodRepository.findById(food.getId()).orElse(null);

        find.setNome(food.getNome());
        find.setDataValidade(food.getDataValidade());

        foodRepository.save(find);

    }

    public List<Food> listar(){
        return foodRepository.findAll();
    }
}
