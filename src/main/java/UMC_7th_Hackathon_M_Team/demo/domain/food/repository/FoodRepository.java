package UMC_7th_Hackathon_M_Team.demo.domain.food.repository;

import UMC_7th_Hackathon_M_Team.demo.domain.food.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {
    Food findByName(String foodName);
    Optional<Food> findByName(String name);
}
