package com.sparta.spring_prac03.repository;

import com.sparta.spring_prac03.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {
}
