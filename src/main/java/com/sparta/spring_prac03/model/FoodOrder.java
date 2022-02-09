package com.sparta.spring_prac03.model;


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

    @ManyToOne
    private Order order;

    public FoodOrder(String name,int quantity,int price,Order order){
        this.name=name;
        this.quantity=quantity;
        this.price=price;
        this.order=order;
    }
}
