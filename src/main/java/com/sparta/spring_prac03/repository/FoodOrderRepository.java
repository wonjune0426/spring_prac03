package com.sparta.spring_prac03.repository;

import com.sparta.spring_prac03.dto.orderResponse.FoodOrderResponseDto;
import com.sparta.spring_prac03.model.FoodOrder;
import com.sparta.spring_prac03.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodOrderRepository extends JpaRepository<FoodOrder,Long> {
    List<FoodOrder> findFoodOrderByOrders(Orders orders);
}
