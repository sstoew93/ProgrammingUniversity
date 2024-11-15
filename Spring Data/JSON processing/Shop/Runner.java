package com.example.demo;

import com.example.demo.services.ProductService;
import com.example.demo.services.SeedService;
import com.example.demo.services.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    private final SeedService seedService;
    private final ProductService productService;
    private final UserService userService;

    private final Gson gson;

    @Autowired
    public Runner(SeedService seedService, ProductService productService, UserService userService, Gson gson) {
        this.seedService = seedService;
        this.productService = productService;
        this.userService = userService;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public void run(String... args) throws Exception {
//        this.seedService.seedData();

//        getProductsInRangeWhereBuyerIsNull();

        getUsersSoldOneItem();


    }

    private void getUsersSoldOneItem() {
        List<String> usersWithSoldProduct = this.userService.findUsersWithSoldProduct();

        usersWithSoldProduct
                .forEach(System.out::println);
    }

    private void getProductsInRangeWhereBuyerIsNull() {
        List<String> byPriceBetweenAndBuyerIsNull = this.productService
                .findByPriceBetweenAndBuyerIsNull(BigDecimal.valueOf(500), BigDecimal.valueOf(1000));

        byPriceBetweenAndBuyerIsNull
                .forEach(System.out::println);

    }
}
