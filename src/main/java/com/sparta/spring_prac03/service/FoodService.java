package com.sparta.spring_prac03.service;


import com.sparta.spring_prac03.dto.FoodRequestDto;
import com.sparta.spring_prac03.model.Food;
import com.sparta.spring_prac03.model.Restaurant;
import com.sparta.spring_prac03.repository.FoodRepository;
import com.sparta.spring_prac03.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;


    @Transactional
    public List<Food> getFoodList(Long restourantId) {
        return foodRepository.findAllByRestourantId(restourantId);
    }

    @Transactional
    public void foodReg(Long restourantId, List<FoodRequestDto> foodList) {
        Restaurant res = restaurantRepository.findById(restourantId).orElseThrow(() -> new NullPointerException("음식점이 존재하지 않습니다."));
        foodList.stream().forEach(foodRequestDto -> {
            int price = foodRequestDto.getPrice();
            if (price < 100||price>1000000) {
                throw new IllegalArgumentException("음식 가격은 100원 미만 1,000,000원 이상입니다.");
            } else if(price % 100 != 0) {
                throw new IllegalArgumentException("음식 가격은 100원 단위로 입력해야 합니다.");
            }
            Optional<Food> found = foodRepository.findFoodByRestourantIdAndName(restourantId, foodRequestDto.getName());
            if (found.isPresent()) {
                throw new IllegalArgumentException("중복된 이름의 음식이 존재합니다.");
            }

            Food food=new Food(foodRequestDto,restourantId);
            foodRepository.save(food);
        });
    }
}

