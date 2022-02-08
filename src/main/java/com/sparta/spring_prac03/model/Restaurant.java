package com.sparta.spring_prac03.model;

import com.sparta.spring_prac03.dto.RestaurantRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Restaurant {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable = false)
    private int minOrderPrice;

    @Column(nullable = false)
    private int deliveryFee;

    public Restaurant(RestaurantRequestDto requestDto){
        this.name=requestDto.getName();
        this.minOrderPrice=requestDto.getMinOrderPrice();
        this.deliveryFee=requestDto.getDeliveryFee();
    }
}
