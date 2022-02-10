package com.sparta.spring_prac03.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class FoodOrder {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="orders_id", nullable = false)
    private Orders orders;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="food_id", nullable = false)
    private Food food;

    public FoodOrder(String name,int quantity,int price,Food food){
        this.name=name;
        this.quantity=quantity;
        this.price=price;
        this.food=food;
    }

}
