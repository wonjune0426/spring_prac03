package com.sparta.spring_prac03.repository;

import com.sparta.spring_prac03.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food,Long> {
    List<Food> findAllByRestourantId(Long restourantId);
}
