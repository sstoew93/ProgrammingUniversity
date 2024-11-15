package com.example.demo.repositories;

import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    @Query("SELECT u FROM User u WHERE (SELECT COUNT(p) from Product p " +
            "where p.seller.id = u.id) > 0 order by u.lastName, u.firstName")
    List<User> findUsersWithSoldProduct();
}
