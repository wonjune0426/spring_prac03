package com.sparta.spring_prac03.service;

import com.sparta.spring_prac03.dto.FoodOrderRequestDto;
import com.sparta.spring_prac03.dto.orderResponse.FoodOrderResponseDto;
import com.sparta.spring_prac03.dto.OrderRequestDto;
import com.sparta.spring_prac03.dto.orderResponse.OrderResponseDto;
import com.sparta.spring_prac03.model.Food;
import com.sparta.spring_prac03.model.FoodOrder;
import com.sparta.spring_prac03.model.Orders;
import com.sparta.spring_prac03.model.Restaurant;
import com.sparta.spring_prac03.repository.FoodOrderRepository;
import com.sparta.spring_prac03.repository.FoodRepository;
import com.sparta.spring_prac03.repository.OrdersRepository;
import com.sparta.spring_prac03.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;
    private final FoodOrderRepository foodOrderRepository;
    private final OrdersRepository ordersRepository;

//    @Transactional
//    public OrderResponseDto orderRequest(OrderRequestDto requestDto) {
//        Restaurant res=restaurantRepository.findById(requestDto.getRestaurantId())
//                .orElseThrow(()->new NullPointerException("등록된 음식점이 없습니다."));
//
//        int sumPrice = 0;
//
//        OrderResponseDto responseDto=new OrderResponseDto();
//        FoodOrder foodOrder=new FoodOrder();
//
//        List<FoodOrderResponseDto> list=new ArrayList<>();
//        List<FoodOrder> flist=new ArrayList<>();
//
//        for(FoodOrderRequestDto foodOrderRequestDto:requestDto.getFoods()){
//            FoodOrderResponseDto foodOrderResponseDto=new FoodOrderResponseDto();
//            Food food=foodRepository.findById(foodOrderRequestDto.getId())
//                    .orElseThrow(()->new NullPointerException("등록된 음식이 없습니다."));
//            int quantity=foodOrderRequestDto.getQuantity();
//            if(quantity<1||quantity>100){
//                throw  new IllegalArgumentException("주문가능 수량은 1~100입니다.");
//            }
//
//            foodOrder.setFood(food);
//            foodOrder.setName(food.getName());
//            foodOrder.setQuantity(quantity);
//            foodOrder.setPrice(food.getPrice()*foodOrderRequestDto.getQuantity());
////            flist.add(foodOrder);
//
//            foodOrderResponseDto.setName(food.getName());
//            foodOrderResponseDto.setQuantity(quantity);
//            foodOrderResponseDto.setPrice(food.getPrice()*quantity);
//            list.add(foodOrderResponseDto);
//            sumPrice+=food.getPrice()*quantity;
//
//        }
//
//        if(sumPrice<res.getMinOrderPrice()){
//            throw new IllegalArgumentException("최소주문금액은"+res.getMinOrderPrice()+"입니다.");
//        }
//
//
//        int totalPrice=sumPrice+res.getDeliveryFee();
//        Orders orders=new Orders();
//        orders.setTotalPrice(totalPrice);
//        orders.setRestaurant(res);
//        orders.setFoodOrders(flist);
//        ordersRepository.save(orders);
//
//        foodOrder.setOrders(orders);
//        foodOrderRepository.save(foodOrder);
//
//        responseDto.setRestaurantName(res.getName());
//        responseDto.setDeliveryFee(res.getDeliveryFee());
//        responseDto.setTotalPrice(totalPrice);
//        responseDto.setFoods(list);
//        return responseDto;
//    }

    @Transactional
    public OrderResponseDto orderRequest(OrderRequestDto requestDto) {
        Restaurant res=restaurantRepository.findById(requestDto.getRestaurantId())
                .orElseThrow(()->new NullPointerException("해당 음식점이 없습니다."));
        int sumprice=0;
        List<FoodOrderResponseDto> foodOrderResponseDtoList=new ArrayList<>();
        List<FoodOrder> foodOrderList=requestDto.getFoods();
        List<FoodOrder> foodOrderList2=new ArrayList<>();

        for(FoodOrder foodOrder:foodOrderList){
            int qentity=foodOrder.getQuantity();
            if(qentity<1||qentity>100){
                throw new IllegalArgumentException("음식 수량은 1~100미만 입니다.");
            }

            Food food=foodRepository.findById(foodOrder.getId())
                    .orElseThrow(()->new NullPointerException("해당 음식이 없습니다."));

            FoodOrder foodOrder1=new FoodOrder(
                    food.getName(),
                    foodOrder.getQuantity(),
                    food.getPrice()*qentity,
                    food
            );
            foodOrderRepository.save(foodOrder1);
            FoodOrderResponseDto foodOrderResponseDto=new FoodOrderResponseDto(foodOrder1);
            foodOrderResponseDtoList.add(foodOrderResponseDto);
            sumprice+=food.getPrice()*qentity;
            foodOrderList2.add(foodOrder1);

        }
        if(sumprice<res.getMinOrderPrice()){
            throw new IllegalArgumentException("음식점의 최소 주문 금액은"+res.getMinOrderPrice()+"입니다.");
        }

        int deliveryFee=res.getDeliveryFee();
        sumprice+=deliveryFee;
        Orders orders=new Orders(res,sumprice,foodOrderList2);
        ordersRepository.save(orders);
        return new OrderResponseDto(orders,deliveryFee,foodOrderResponseDtoList);
    }

    @Transactional
    public List<OrderResponseDto> getAllorders() {
        List<OrderResponseDto> orderResponseDtoList= new ArrayList<>();
        List<Orders> ordersList=ordersRepository.findAll();

        for(Orders orders:ordersList){
            Restaurant res=restaurantRepository.findByName(orders.getRestaurant().getName());
            int deliveryFee=res.getDeliveryFee();
            List<FoodOrderResponseDto> foodOrderResponseDtoList=new ArrayList<>();

            List<FoodOrder> foodOrderList=foodOrderRepository.findFoodOrderByOrders(orders);
            for(FoodOrder foodOrder:foodOrderList){
                FoodOrderResponseDto foodOrderResponseDto=
                        new FoodOrderResponseDto(foodOrder);
                foodOrderResponseDtoList.add(foodOrderResponseDto);
            }
            OrderResponseDto orderResponseDto=new OrderResponseDto(orders,deliveryFee,foodOrderResponseDtoList);
            orderResponseDtoList.add(orderResponseDto);
        }
        return orderResponseDtoList;
    }


}
