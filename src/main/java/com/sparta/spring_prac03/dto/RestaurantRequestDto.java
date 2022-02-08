package com.sparta.spring_prac03.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor //모든 필드의 값을 포함한 생성자 자동 생성
@Getter
public class RestaurantRequestDto {

    private String name;

    private int minOrderPrice;

    private int deliveryFee;
}
