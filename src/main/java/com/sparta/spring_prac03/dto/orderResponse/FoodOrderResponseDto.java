package com.sparta.spring_prac03.dto.orderResponse;

import com.sparta.spring_prac03.model.FoodOrder;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor //모든 필드의 값을 포함한 생성자 자동 생성
@Getter
@Setter
@ToString
public class FoodOrderResponseDto {
    private String name;
    private int quantity;
    private int price;

    public FoodOrderResponseDto(FoodOrder foodOrder) {
        this.name=foodOrder.getName();
        this.quantity=foodOrder.getQuantity();
        this.price=foodOrder.getPrice();
    }
}
