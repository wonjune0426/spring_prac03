package com.sparta.spring_prac03.model;

import com.sparta.spring_prac03.dto.FoodRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Food {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;


    @Column(nullable = false)
    private Long restourantId;

    public Food(FoodRequestDto foodRequestDto,Long restourantId){
        this.name=foodRequestDto.getName();
        this.price=foodRequestDto.getPrice();
        this.restourantId=restourantId;
    }
}
