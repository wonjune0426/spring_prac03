package com.sparta.spring_prac03.dto;

import com.sparta.spring_prac03.model.FoodOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;



@NoArgsConstructor
@AllArgsConstructor //모든 필드의 값을 포함한 생성자 자동 생성
@Getter
@Setter
public class OrderRequestDto {
    private Long restaurantId;
    private List<FoodOrder> foods;
}
