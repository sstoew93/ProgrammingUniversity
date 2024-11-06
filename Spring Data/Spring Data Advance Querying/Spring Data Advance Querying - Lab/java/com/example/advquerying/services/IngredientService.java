package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IngredientService {
    List<String> findIngredientsByNameStartingWith(String name);
    List<String> findIngredientsByNameInOrderByName(List<String> input);

    void deleteIngredientsByName(String name);

    void updateALLIngredientsByPrice();

    void updateALLIngredientsByPriceForNames(List<String> names);
}
