package com.example.demo.services.impl;

import com.example.demo.dtos.ProductWithoutBuyerDTO;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.ProductService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final Gson gson;
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository, Gson gson) {
        this.productRepository = productRepository;
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public List<String> findByPriceBetweenAndBuyerIsNull(BigDecimal from, BigDecimal to) {

        ModelMapper modelMapper = new ModelMapper();
        List<String> collect = this.productRepository.findByPriceBetweenAndBuyerIsNull(from, to)
                .stream()
                .map(dto -> modelMapper.map(dto, ProductWithoutBuyerDTO.class))
                .map(gson::toJson)
                .collect(Collectors.toList());

        return collect;

    }

}
