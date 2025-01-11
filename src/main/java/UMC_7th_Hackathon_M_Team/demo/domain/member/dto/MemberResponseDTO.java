package UMC_7th_Hackathon_M_Team.demo.domain.member.dto;

import java.util.List;

import UMC_7th_Hackathon_M_Team.demo.domain.food.dto.FoodResponseDTO;
import UMC_7th_Hackathon_M_Team.demo.domain.foodPrefer.entity.FoodPrefer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MemberResponseDTO {

	@Getter
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class MyPageResponseDTO{

		private Long memberId;
		private String memberName;
		private List<FoodResponseDTO.FoodListDTO> foodList;
	}

	@Getter
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class ChangeNameResponseDTO{

		private Long memberId;
		private String memberName;
	}

	@Getter
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class ChangeFoodResponseDTO{

		private Long memberId;
		private List<String> foodList;
	}
}
