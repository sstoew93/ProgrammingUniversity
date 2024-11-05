package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface ShampooService {
    List<Shampoo> findShampoosBySizeOrderById(Size size);
    List<Shampoo> findShampoosBySizeOrLabelIdOrderByPriceAsc(Size size, Long labelId);
    List<Shampoo> findShampoosByPriceGreaterThanOrderByPriceDesc(BigDecimal bigDecimal);
    Long getCountOfAllShampooWithPriceLowerThan(BigDecimal price);
    List<String> findAllByIngredientsNameIn(Set<String> ingredients);

    List<String> getShampooByIngredientsCount(int input);
}
