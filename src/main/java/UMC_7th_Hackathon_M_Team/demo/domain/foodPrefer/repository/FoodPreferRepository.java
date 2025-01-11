package UMC_7th_Hackathon_M_Team.demo.domain.foodPrefer.repository;

import UMC_7th_Hackathon_M_Team.demo.domain.foodPrefer.entity.FoodPrefer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodPreferRepository extends JpaRepository<FoodPrefer, Long> {
}
