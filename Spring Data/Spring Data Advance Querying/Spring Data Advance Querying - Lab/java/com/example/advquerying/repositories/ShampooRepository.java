package com.example.advquerying.repositories;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    List<Shampoo> findShampoosBySizeOrderById(Size size);
    List<Shampoo> findShampoosBySizeOrLabelId(Size size, Long labelId);
    List<Shampoo> findShampoosByPriceGreaterThanOrderByPriceDesc(BigDecimal bigDecimal);
    Set<Shampoo> findAllByPriceLessThan(BigDecimal price);
    List<Shampoo> findAllByIngredientsNameIn(Set<String> ingredients);
    @Query("FROM Shampoo s WHERE size(s.ingredients) < :input ")
    List<Shampoo> getShampooByIngredientsCount(int input);
}
