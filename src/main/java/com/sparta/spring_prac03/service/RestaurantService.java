package com.sparta.spring_prac03.service;

import com.sparta.spring_prac03.dto.RestaurantRequestDto;
import com.sparta.spring_prac03.model.Restaurant;
import com.sparta.spring_prac03.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public Restaurant resRegister(RestaurantRequestDto requestDto) {
        int minOrder=requestDto.getMinOrderPrice();
        int minDel=requestDto.getDeliveryFee();
        if(minOrder>100000||minOrder<1000){
            throw new IllegalArgumentException("금액은 1,000원 이상 100,000원 이하로만 입력해주세요");
        } else if(minOrder%100!=0){
            throw new IllegalArgumentException("금액은 100원 단위로만 입력 가능합니다.");
        }

        if(minDel>10000||minDel<0){
            throw new IllegalArgumentException("금액은 0원 이상 10,000원 이하로만 입력해주세요");
        }else if(minDel%500!=0){
            throw new IllegalArgumentException("금액은 500원 단위로만 입력가능합니다.");
        }
        Restaurant res=new Restaurant(requestDto);
       restaurantRepository.save(res);
        return res;
    }

    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }
}
