package com.sparta.spring_prac03.service;

import com.sparta.spring_prac03.dto.FoodOrderRequestDto;
import com.sparta.spring_prac03.dto.OrderRequestDto;
import com.sparta.spring_prac03.model.Food;
import com.sparta.spring_prac03.model.FoodOrder;
import com.sparta.spring_prac03.model.Order;
import com.sparta.spring_prac03.model.Restaurant;
import com.sparta.spring_prac03.repository.FoodOrderRepository;
import com.sparta.spring_prac03.repository.FoodRepository;
import com.sparta.spring_prac03.repository.OrderRepository;
import com.sparta.spring_prac03.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;
    private final FoodOrderRepository foodOrderRepository;
    private final OrderRepository orderRepository;

    @Transactional
    public Order orderRequest(OrderRequestDto requestDto) {
        Restaurant res = restaurantRepository.findById(requestDto.getRestaurantId()).
                orElseThrow(() -> new NullPointerException("음식점이 존재하지 않습니다."));

        int totalPrice = 0;
        Order order = new Order();
        orderRepository.save(order);
        List<FoodOrder> foodOrders=new ArrayList<>();
        List<FoodOrderRequestDto> foods = requestDto.getFoods();

            for (FoodOrderRequestDto foodOrderRequestDto : foods) {
                Food food = foodRepository.findById(foodOrderRequestDto.getId()).
                        orElseThrow(() -> new NullPointerException("음식이 존재하지 않습니다."));
                int quantity = foodOrderRequestDto.getQuantity();
                if (quantity > 100 || quantity < 1) {
                    throw new IllegalArgumentException("주문수량은 1~100까지 가능합니다.");
                }


                FoodOrder foodOrder = new FoodOrder(food.getName(), quantity, food.getPrice(),order);
                foodOrderRepository.save(foodOrder);
                totalPrice += food.getPrice();
                foodOrders.add(foodOrder);
//                order.addFoodOrder(foodOrder);
            }

            order.setDeliveryFee(res.getDeliveryFee());
            if (totalPrice + res.getDeliveryFee() < res.getMinOrderPrice()) {
                throw new IllegalArgumentException("최소 주문금액은 " + res.getMinOrderPrice() + "입니다.");
            }
            order.setTotalPrice(totalPrice + res.getDeliveryFee());
            return order;
    }
}
