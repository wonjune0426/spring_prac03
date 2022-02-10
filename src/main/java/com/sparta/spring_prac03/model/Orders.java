package com.sparta.spring_prac03.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id; // 주문id

    @Column(nullable = false)
    private int totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant; // 음식적ID

//    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orders_id")
    private List<FoodOrder> foodOrders = new ArrayList<>();


    public Orders(Restaurant res,int sumprice, List<FoodOrder> foodOrderList2) {
        this.restaurant=res;
        this.totalPrice=sumprice;
        this.foodOrders=foodOrderList2;
    }
}
