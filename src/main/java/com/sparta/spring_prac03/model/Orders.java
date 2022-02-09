package com.sparta.spring_prac03.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "orders")
@NoArgsConstructor
public class Orders {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id; // 주문id

//    @Column(nullable = false)
//    private String restaurantName;

//    @Column(nullable = false)
//    private int deliveryFee;

    @Column(nullable = false)
    private int totalPrice;

//    @OneToMany(mappedBy = "orders")
//    private List<FoodOrder> foodOrderList=new ArrayList<>();

//    public void addFoodOrder(FoodOrder foodOrder){
//        this.foodOrderList.add(foodOrder);
//    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant; // 음식적ID

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<FoodOrder> foodOrders = new ArrayList<>();


}
