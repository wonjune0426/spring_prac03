package com.sparta.spring_prac03.repository;

import com.sparta.spring_prac03.model.Food;
import com.sparta.spring_prac03.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food,Long> {
    Optional<Food> findFoodByRestaurantAndName(Restaurant res, String name);

    List<Food> findFoodByRestaurant(Restaurant res);
}
