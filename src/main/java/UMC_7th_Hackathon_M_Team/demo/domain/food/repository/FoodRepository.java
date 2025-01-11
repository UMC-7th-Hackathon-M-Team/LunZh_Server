package UMC_7th_Hackathon_M_Team.demo.domain.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import UMC_7th_Hackathon_M_Team.demo.domain.food.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {
	Food findByName(String foodName);
}
