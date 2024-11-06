package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findIngredientsByNameStartingWith(String letter);
    List<Ingredient> findIngredientsByNameInOrderByName(List<String> input);

    @Transactional
    @Modifying
    @Query("DELETE Ingredient WHERE name = :name")
    void deleteIngredientsByName(String name);

    @Transactional
    @Modifying
    @Query("UPDATE Ingredient i SET i.price = i.price * 1.10")
    void updateALLIngredientsByPrice();

    @Transactional
    @Modifying
    @Query("UPDATE Ingredient i SET i.price = i.price * 1.10")
    void updateALLIngredientsByPriceForNames(List<String> names);
}
