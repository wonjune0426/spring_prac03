package com.sparta.spring_prac03.model;

import com.sparta.spring_prac03.dto.FoodRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "food")
public class Food {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @OneToMany(mappedBy = "food")
    private List<FoodOrder> foodOrders = new ArrayList<>();


    public Food(FoodRequestDto foodRequestDto, Restaurant res) {
        this.name=foodRequestDto.getName();
        this.price=foodRequestDto.getPrice();
        this.restaurant=res;
    }
}