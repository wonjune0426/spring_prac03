package com.sparta.spring_prac03.service;

import com.sparta.spring_prac03.dto.FoodOrderRequestDto;
import com.sparta.spring_prac03.dto.OrderRequestDto;
import com.sparta.spring_prac03.model.Food;
import com.sparta.spring_prac03.model.FoodOrder;
import com.sparta.spring_prac03.model.Orders;
import com.sparta.spring_prac03.model.Restaurant;
import com.sparta.spring_prac03.repository.FoodOrderRepository;
import com.sparta.spring_prac03.repository.FoodRepository;
import com.sparta.spring_prac03.repository.OrderRepository;
import com.sparta.spring_prac03.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    public void orderRequest(OrderRequestDto requestDto) {
//        Restaurant res = restaurantRepository.findById(requestDto.getRestaurantId()).
//                orElseThrow(() -> new NullPointerException("음식점이 존재하지 않습니다."));
//
//
//        int totalPrice = 0;
//        Orders orders = new Orders();
//
//        List<FoodOrderRequestDto> foods = requestDto.getFoods();
//
//            for (FoodOrderRequestDto foodOrderRequestDto : foods) {
//                Food food = foodRepository.findById(foodOrderRequestDto.getId()).
//                        orElseThrow(() -> new NullPointerException("음식이 존재하지 않습니다."));
//                int quantity = foodOrderRequestDto.getQuantity();
//                if (quantity > 100 || quantity < 1) {
//                    throw new IllegalArgumentException("주문수량은 1~100까지 가능합니다.");
//                }
//
//                FoodOrder foodOrder = new FoodOrder(food.getName(), quantity, food.getPrice()*quantity, orders);
//                foodOrderRepository.save(foodOrder);
//                totalPrice += food.getPrice()*quantity;
//            }
//
//
//            if (totalPrice + res.getDeliveryFee() < res.getMinOrderPrice()) {
//                throw new IllegalArgumentException("최소 주문금액은 " + res.getMinOrderPrice() + "입니다.");
//            }
//            orders.setTotalPrice(totalPrice + res.getDeliveryFee());
//            orderRepository.save(orders);
//
//            return orders;

    }

}
