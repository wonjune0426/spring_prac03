package com.sparta.spring_prac03.controller;

import com.sparta.spring_prac03.dto.RestaurantRequestDto;
import com.sparta.spring_prac03.model.Restaurant;
import com.sparta.spring_prac03.service.RestaurantService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping("/restaurant/register")
    public Restaurant resRegister(@RequestBody RestaurantRequestDto requestDto){
        return restaurantService.resRegister(requestDto);
    }
    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurants(){
        return restaurantService.getRestaurants();
    }
}
