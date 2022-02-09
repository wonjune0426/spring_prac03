package com.sparta.spring_prac03.controller;

import com.sparta.spring_prac03.dto.FoodOrderRequestDto;
import com.sparta.spring_prac03.dto.OrderRequestDto;
import com.sparta.spring_prac03.model.Order;
import com.sparta.spring_prac03.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/order/request")
    public Order orderRequest(@RequestBody OrderRequestDto requestDto){
        return orderService.orderRequest(requestDto);
    }
}
