package UMC_7th_Hackathon_M_Team.demo.domain.food.mapper;

import UMC_7th_Hackathon_M_Team.demo.domain.food.entity.Food;
import UMC_7th_Hackathon_M_Team.demo.domain.foodPrefer.entity.FoodPrefer;
import UMC_7th_Hackathon_M_Team.demo.domain.member.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class FoodPreferMapper {

    public FoodPrefer toFoodPrefer(Member member, Food food){
        return FoodPrefer.builder()
                .member(member)
                .food(food)
                .build();
    }

}
