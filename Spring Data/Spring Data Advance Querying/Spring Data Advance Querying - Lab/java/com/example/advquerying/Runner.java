package com.example.advquerying;

import com.example.advquerying.entities.Size;
import com.example.advquerying.services.IngredientService;
import com.example.advquerying.services.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


@Component
public class Runner implements CommandLineRunner {

    private final ShampooService shampooService;
    private final IngredientService ingredientService;

    public Runner(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {

        this.shampooService.findShampoosBySizeOrderById(Size.valueOf("MEDIUM"))
                .forEach(shampoo -> {
                    System.out.printf("%s %.2f", shampoo.getBrand(), shampoo.getPrice()).append(System.lineSeparator());
                });

        this.shampooService.findShampoosBySizeOrLabelIdOrderByPriceAsc(Size.valueOf("MEDIUM"), 10L)
                .forEach(shampoo -> {
                    System.out.printf("%s %.2f", shampoo.getBrand(), shampoo.getPrice()).append(System.lineSeparator());
                });

        this.shampooService.findShampoosByPriceGreaterThanOrderByPriceDesc(BigDecimal.valueOf(5))
                .forEach(shampoo -> {
                    System.out.printf("%s %.2f", shampoo.getBrand(), shampoo.getPrice()).append(System.lineSeparator());
                });

        this.ingredientService.findIngredientsByNameStartingWith("M")
                .forEach(System.out::println);


        this.ingredientService.findIngredientsByNameInOrderByName(List.of("Apple", "Lavender", "Herbs"))
                .forEach(System.out::println);

        System.out.println(this.shampooService.getCountOfAllShampooWithPriceLowerThan(BigDecimal.valueOf(8.5)));

        this.shampooService.findAllByIngredientsNameIn(Set.of("Berry", "Mineral-Colagen"))
                .forEach(System.out::println);

        this.shampooService.getShampooByIngredientsCount(2)
                .forEach(System.out::println);

        this.ingredientService.deleteIngredientsByName("Lavender");

        this.ingredientService.updateALLIngredientsByPrice();

        this.ingredientService.updateALLIngredientsByPriceForNames(List.of("Aloe Vera", "Berry"));

    }

}
