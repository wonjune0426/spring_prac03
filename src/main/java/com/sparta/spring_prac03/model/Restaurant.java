package com.sparta.spring_prac03.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sparta.spring_prac03.dto.RestaurantRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "restaurant")
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

    @OneToMany(mappedBy = "restaurant")
    private List<Orders> orders = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant")
    @JsonIgnoreProperties({"restaurant"}) // 무한참조 방지
    private List<Food> foods = new ArrayList<>();

    public Restaurant(RestaurantRequestDto requestDto){
        this.name=requestDto.getName();
        this.minOrderPrice=requestDto.getMinOrderPrice();
        this.deliveryFee=requestDto.getDeliveryFee();
    }
}
