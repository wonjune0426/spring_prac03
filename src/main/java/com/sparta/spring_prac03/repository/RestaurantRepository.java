package com.sparta.spring_prac03.repository;

import com.sparta.spring_prac03.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
    Restaurant findByName(String name);
}
