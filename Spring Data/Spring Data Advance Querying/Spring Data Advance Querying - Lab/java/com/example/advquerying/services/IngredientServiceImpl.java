package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    @Override
    public List<String> findIngredientsByNameStartingWith(String letter) {
        return this.ingredientRepository.findIngredientsByNameStartingWith(letter)
                .stream()
                .map(Ingredient::getName)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findIngredientsByNameInOrderByName(List<String> input) {
        return this.ingredientRepository.findIngredientsByNameInOrderByName(input)
                .stream()
                .map(Ingredient::getName)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteIngredientsByName(String name) {
        this.ingredientRepository.deleteIngredientsByName(name);
    }

    @Override
    public void updateALLIngredientsByPrice() {
        this.ingredientRepository.updateALLIngredientsByPrice();
    }

    @Override
    public void updateALLIngredientsByPriceForNames(List<String> names) {
        this.ingredientRepository.updateALLIngredientsByPriceForNames(names);
    }


}
