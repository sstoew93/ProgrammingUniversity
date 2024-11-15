package com.example.demo.services;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface ProductService {
    List<String> findByPriceBetweenAndBuyerIsNull(BigDecimal from, BigDecimal to);
}
