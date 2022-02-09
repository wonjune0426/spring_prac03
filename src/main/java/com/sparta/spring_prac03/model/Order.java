package com.sparta.spring_prac03.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "OrderTable")
@NoArgsConstructor
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @OneToMany(mappedBy = "order")
    private List<FoodOrder> foodOrderList;

    @Column(nullable = false)
    private int deliveryFee;

    @Column(nullable = false)
    private int totalPrice;

//    public void addFoodOrder(FoodOrder foodOrder){
//        this.foodOrderList.add(foodOrder);
//    }
}
