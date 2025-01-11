package UMC_7th_Hackathon_M_Team.demo.domain.member.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import UMC_7th_Hackathon_M_Team.demo.domain.food.entity.Food;
import UMC_7th_Hackathon_M_Team.demo.domain.food.repository.FoodRepository;
import UMC_7th_Hackathon_M_Team.demo.domain.foodPrefer.entity.FoodPrefer;
import UMC_7th_Hackathon_M_Team.demo.domain.foodPrefer.repository.FoodPreferRepository;
import UMC_7th_Hackathon_M_Team.demo.domain.member.converter.MemberConverter;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.MemberRequestDTO;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.MemberResponseDTO;
import UMC_7th_Hackathon_M_Team.demo.domain.member.entity.Member;
import UMC_7th_Hackathon_M_Team.demo.domain.member.repository.MemberRepository;
import UMC_7th_Hackathon_M_Team.demo.global.exeption.CustomApiException;
import UMC_7th_Hackathon_M_Team.demo.global.exeption.ErrorCode;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	private final FoodPreferRepository foodPreferRepository;
	private final FoodRepository foodRepository;

	@Transactional
	public MemberResponseDTO.MyPageResponseDTO getMyPage(Long id){

		Member member = memberRepository.findById(id).orElseThrow(
			()-> new CustomApiException(ErrorCode.USER_NOT_FOUND));

		return MemberConverter.toMyPageResponseDTO(member);
	}

	@Transactional
	public MemberResponseDTO.ChangeNameResponseDTO changeName(Long id, MemberRequestDTO.changeNameDto request){

		Member member = memberRepository.findById(id).orElseThrow(()->new CustomApiException(ErrorCode.USER_NOT_FOUND));

		member.changeNickName(request.getName());

		return MemberConverter.toChangeNameResponseDTO(member);
	}

	@Transactional
	public List<FoodPrefer> changeFoodPrefer(Long id, List<String> foodList){

		Member member = memberRepository.findById(id).orElseThrow(()->new CustomApiException(ErrorCode.USER_NOT_FOUND));

		foodPreferRepository.deleteByMember(member);

		List<FoodPrefer> newPreferList = foodList.stream()
			.map(foodName -> {
				Food food = foodRepository.findByName(foodName);
				return FoodPrefer.builder()
					.food(food)
					.member(member)
					.build();
			})
				.collect(Collectors.toList());


		foodPreferRepository.saveAll(newPreferList);
		return newPreferList;
	}
}
