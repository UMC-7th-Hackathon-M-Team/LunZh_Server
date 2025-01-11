package UMC_7th_Hackathon_M_Team.demo.domain.member.converter;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import UMC_7th_Hackathon_M_Team.demo.domain.food.dto.FoodResponseDTO;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.MemberRequestDTO;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.MemberResponseDTO;
import UMC_7th_Hackathon_M_Team.demo.domain.member.entity.Member;


public class MemberConverter {

	public static MemberResponseDTO.MyPageResponseDTO toMyPageResponseDTO(Member member) {
		return MemberResponseDTO.MyPageResponseDTO.builder()
			.memberId(member.getId())
			.memberName(member.getNickname())
			.foodList(
				member.getFoodPreferList().stream()
					.map(foodPrefer -> FoodResponseDTO.FoodListDTO.builder()
						.foodName(foodPrefer.getFood().getName())
						.build()
					)
					.collect(Collectors.toList())
			)
			.build();
	}

	public static MemberResponseDTO.ChangeNameResponseDTO toChangeNameResponseDTO(Member member) {
		return MemberResponseDTO.ChangeNameResponseDTO.builder()
			.memberId(member.getId())
			.memberName(member.getNickname())
			.build();
	}

	public static MemberResponseDTO.HomeResponseDTO toHomeResponseDTO(Boolean hasGroup, Member member, String groupName) {
		return MemberResponseDTO.HomeResponseDTO.builder()
			.memberName(member.getNickname())
			.hasGroup(hasGroup)
			.groupName(groupName)
			.build();
	}


}
