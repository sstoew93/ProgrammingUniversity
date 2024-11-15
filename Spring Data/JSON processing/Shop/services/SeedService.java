package com.example.demo.services;

import java.io.FileNotFoundException;

public interface SeedService {
    void seedUsers() throws FileNotFoundException;
    void seedCategories() throws FileNotFoundException;
    void seedProducts() throws FileNotFoundException;

    default void seedData() throws FileNotFoundException {
        seedUsers();
        seedCategories();
        seedProducts();
    }
}
