package com.sparta.spring_prac03.controller;

import com.sparta.spring_prac03.dto.FoodRequestDto;
import com.sparta.spring_prac03.model.Food;
import com.sparta.spring_prac03.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FoodController {
    private final FoodService foodService;

    @PostMapping("/restaurant/{restourantId}/food/register")
    public void foodRegister(@PathVariable Long restourantId, @RequestBody List<FoodRequestDto> foodList) {
        foodService.foodReg(restourantId,foodList);
    }

    @GetMapping("/restaurant/{restourantId}/foods")
    private List<Food> getFoodlist(@PathVariable Long restourantId){
        return foodService.getFoodList(restourantId);
    }
}
