package com.sparta.spring_prac03.repository;

import com.sparta.spring_prac03.model.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodOrderRepository extends JpaRepository<FoodOrder,Long> {
}
