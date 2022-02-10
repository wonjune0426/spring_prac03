package com.sparta.spring_prac03.controller;

import com.sparta.spring_prac03.dto.OrderRequestDto;
import com.sparta.spring_prac03.dto.orderResponse.OrderResponseDto;
import com.sparta.spring_prac03.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

//    @PostMapping("/order/request")
//    public ResponseEntity<OrderResponseDto> orderRequest(@RequestBody OrderRequestDto requestDto) {
//        OrderResponseDto responseDto= orderService.orderRequest(requestDto);
//        return ResponseEntity.ok(responseDto);
//    }

    @PostMapping("order/request")
    public OrderResponseDto orderRequest(@RequestBody OrderRequestDto requestDto){
        return orderService.orderRequest(requestDto);
    }

    @GetMapping("/orders")
    public List<OrderResponseDto> orders(){
        return orderService.getAllorders();
    }


}
