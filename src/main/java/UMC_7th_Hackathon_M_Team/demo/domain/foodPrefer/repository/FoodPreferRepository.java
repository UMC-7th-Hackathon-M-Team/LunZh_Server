package UMC_7th_Hackathon_M_Team.demo.domain.foodPrefer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import UMC_7th_Hackathon_M_Team.demo.domain.foodPrefer.entity.FoodPrefer;
import UMC_7th_Hackathon_M_Team.demo.domain.member.entity.Member;

public interface FoodPreferRepository extends JpaRepository<FoodPrefer, Long> {
	void deleteByMember(Member member);
}
