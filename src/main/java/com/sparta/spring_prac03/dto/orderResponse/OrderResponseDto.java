package com.sparta.spring_prac03.dto.orderResponse;

import com.sparta.spring_prac03.model.Orders;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor //모든 필드의 값을 포함한 생성자 자동 생성
@Getter
@Setter
@ToString
public class OrderResponseDto {
    private String restaurantName;
    private List<FoodOrderResponseDto> foods;
    private int deliveryFee;
    private int totalPrice;


    public OrderResponseDto(Orders orders, int deliveryFee, List<FoodOrderResponseDto> foodOrderResponseDtoList) {
       this.restaurantName=orders.getRestaurant().getName();
       this.foods=foodOrderResponseDtoList;
       this.deliveryFee=deliveryFee;
       this.totalPrice=orders.getTotalPrice();
    }
}
