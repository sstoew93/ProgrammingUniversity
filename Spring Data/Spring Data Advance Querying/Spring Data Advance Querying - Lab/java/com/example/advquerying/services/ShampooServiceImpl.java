package com.example.advquerying.services;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.repositories.ShampooRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShampooServiceImpl implements ShampooService {
    private final ShampooRepository shampooRepository;

    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }


    @Override
    public List<Shampoo> findShampoosBySizeOrderById(Size size) {
        return this.shampooRepository.findShampoosBySizeOrderById(size);
    }

    @Override
    public List<Shampoo> findShampoosBySizeOrLabelIdOrderByPriceAsc(Size size, Long labelId) {
        return this.shampooRepository.findShampoosBySizeOrLabelId(size, labelId);

    }

    @Override
    public List<Shampoo> findShampoosByPriceGreaterThanOrderByPriceDesc(BigDecimal bigDecimal) {
        return this.shampooRepository.findShampoosByPriceGreaterThanOrderByPriceDesc(bigDecimal);
    }

    @Override
    public Long getCountOfAllShampooWithPriceLowerThan(BigDecimal price) {
        return (long) this.shampooRepository.findAllByPriceLessThan(price).size();
    }

    @Override
    public List<String> findAllByIngredientsNameIn(Set<String> ingredients) {
        return this.shampooRepository.findAllByIngredientsNameIn(ingredients)
                .stream()
                .map(Shampoo::getBrand)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getShampooByIngredientsCount(int input) {
        return this.shampooRepository.getShampooByIngredientsCount(input)
                .stream()
                .map(Shampoo::getBrand)
                .collect(Collectors.toList());
    }


}
