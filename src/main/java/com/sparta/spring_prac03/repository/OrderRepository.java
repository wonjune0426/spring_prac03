package com.sparta.spring_prac03.repository;

import com.sparta.spring_prac03.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
