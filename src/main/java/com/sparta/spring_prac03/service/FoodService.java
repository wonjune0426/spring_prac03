package com.sparta.spring_prac03.service;


import com.sparta.spring_prac03.model.Food;
import com.sparta.spring_prac03.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;

    public void foodReg(Long restourantId, Food food) {
        List<Food> foodList=foodRepository.findAll();
        int price=food.getPrice();
        for(int i=0;i<foodList.size();i++){
            Food chkFood=foodList.get(i);
            if(chkFood.getRestourantId().equals(restourantId)&&
                chkFood.getName().equals(food.getName())){
                throw new IllegalArgumentException("같은 가게에서는 동일한 음식 등록이 불가 합니다.");
            }
        }


        if(price<100||price>1000000){
            throw new IllegalArgumentException("금액은 100원 이상 1000000원 이하만 가능합니다.");
        }else if(price%100!=0){
            throw new IllegalArgumentException("금액은 100원 단위로만 가능합니다.");
        }

        Food savefood=new Food(food.getName(),food.getPrice(),restourantId);
        foodRepository.save(savefood);
    }

    public List<Food> getFoodList(Long restourantId) {
        return foodRepository.findAllByRestourantId(restourantId);
    }
}
