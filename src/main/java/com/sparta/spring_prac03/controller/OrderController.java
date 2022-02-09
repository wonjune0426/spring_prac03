package com.sparta.spring_prac03.controller;

import com.sparta.spring_prac03.dto.OrderRequestDto;
import com.sparta.spring_prac03.model.Orders;
import com.sparta.spring_prac03.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/order/request")
    public void aa(@RequestBody OrderRequestDto requestDto) {
    }


}
