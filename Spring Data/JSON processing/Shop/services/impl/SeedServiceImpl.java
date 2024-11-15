package com.example.demo.services.impl;

import com.example.demo.dtos.CategoryImportDTO;
import com.example.demo.dtos.ProductImportDTO;
import com.example.demo.dtos.UserImportDTO;
import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.entities.User;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.SeedService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SeedServiceImpl implements SeedService {

    private static final String CATEGORIES_JSON = "src/main/resources/categories.json";
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    private ModelMapper modelMapper;
    private Gson gson;

    private static final String USERS_JSON = "src/main/resources/users.json";

    public SeedServiceImpl(UserRepository userRepository, CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.modelMapper = new ModelMapper();
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public void seedUsers() throws FileNotFoundException {
        FileReader fileReader = new FileReader(USERS_JSON);
        UserImportDTO[] userImportDTOS = this.gson.fromJson(fileReader, UserImportDTO[].class);

        List<User> users = Arrays.stream(userImportDTOS)
                .map(dto -> this.modelMapper.map(dto, User.class))
                .collect(Collectors.toList());

        this.userRepository.saveAll(users);
    }

    @Override
    public void seedCategories() throws FileNotFoundException {
        FileReader fileReader = new FileReader(CATEGORIES_JSON);
        CategoryImportDTO[] categoryImportDTOS = this.gson.fromJson(fileReader, CategoryImportDTO[].class);

        List<Category> categories = Arrays.stream(categoryImportDTOS)
                .map(dt0 -> this.modelMapper.map(dt0, Category.class))
                .collect(Collectors.toList());

        this.categoryRepository.saveAll(categories);
    }

    @Override
    public void seedProducts() throws FileNotFoundException {
        FileReader fileReader = new FileReader(CATEGORIES_JSON);
        ProductImportDTO[] ProductImportDTOS = this.gson.fromJson(fileReader, ProductImportDTO[].class);

        List<Product> products = Arrays.stream(ProductImportDTOS)
                .map(dt0 -> this.modelMapper.map(dt0, Product.class))
                .map(this::setRandomSeller)
                .map(this::setRandomBuyer)
                .map(this::setRandomCategory)
                .collect(Collectors.toList());

        this.productRepository.saveAll(products);
    }

    private Product setRandomCategory(Product product) {

        Random random = new Random();

        long dbCOunt = this.categoryRepository.count();

        long count = random.nextInt((int) dbCOunt);

        Set<Category> categories = new HashSet<>();

        for (int i = 0; i < count; i++) {
            long randomId = random.nextInt((int) dbCOunt) + 1;

            Optional<Category> category = this.categoryRepository.findById(randomId);

            categories.add(category.get());
        }

        product.setCategory(categories);


        return product;
    }

    private Product setRandomBuyer(Product product) {
        if (product.getPrice().compareTo(BigDecimal.valueOf(944)) > 0) {
            return product;
        }

        long usersCount = this.userRepository.count();

        long randomUserId = (int) (Math.random() * usersCount);

        Optional<User> buyer = this.userRepository.findById(randomUserId);

        product.setBuyer(buyer.get());

        return product;
    }

    private Product setRandomSeller(Product product) {
        long usersCount = this.userRepository.count();

        long randomUserId = (int) (Math.random() * usersCount);

        Optional<User> seller = this.userRepository.findById(randomUserId);

        return product;
    }



}
