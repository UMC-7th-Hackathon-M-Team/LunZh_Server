package UMC_7th_Hackathon_M_Team.demo.domain.member.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import UMC_7th_Hackathon_M_Team.demo.domain.foodPrefer.entity.FoodPrefer;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.MemberRequestDTO;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.MemberResponseDTO;
import UMC_7th_Hackathon_M_Team.demo.domain.member.service.MemberService;
import UMC_7th_Hackathon_M_Team.demo.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class MemberController {

	private final MemberService memberService;

	@Operation(
		summary = "마이페이지 조회 API",
		description = "마이페이지를 조회하는 API입니다. 닉네임, 음식 즐찾.",
		responses = {
			@ApiResponse(responseCode = "200", description = "OK, 성공", content = @Content(mediaType = "application/json"))
		},
		parameters = {
			@Parameter(name = "memberId", description = "나의 아이디, path variable 입니다!", in = ParameterIn.PATH)
		}
	)
	@GetMapping("/{memberId}")
	public BaseResponse<MemberResponseDTO.MyPageResponseDTO> myPage(@PathVariable(name = "memberId") Long memberId) {
		return BaseResponse.onSuccess(memberService.getMyPage(memberId));
	}

	@Operation(
		summary = "닉네임 변경 API",
		description = "닉네임 변경 API입니다.",
		responses = {
			@ApiResponse(responseCode = "200", description = "OK, 성공", content = @Content(mediaType = "application/json"))
		},
		parameters = {
			@Parameter(name = "memberId", description = "나의 아이디, path variable 입니다!", in = ParameterIn.PATH)
		}
	)
	@PostMapping("/nickname/{memberId}")
	public BaseResponse<MemberResponseDTO.ChangeNameResponseDTO> changeName(@RequestBody @Valid MemberRequestDTO.changeNameDto request,
											@PathVariable(name = "memberId") Long memberId){
		return BaseResponse.onSuccess(memberService.changeName(memberId, request));
	}

	@Operation(
		summary = "즐겨찾는 음식 리스트 변경 API",
		description = "즐겨찾는 음식 리스트 변경 API입니다.",
		responses = {
			@ApiResponse(responseCode = "200", description = "OK, 성공", content = @Content(mediaType = "application/json"))
		},
		parameters = {
			@Parameter(name = "memberId", description = "나의 아이디, path variable 입니다!", in = ParameterIn.PATH)
		}
	)
	@PostMapping("/food/{memberId}")
	public BaseResponse<List<FoodPrefer>> changeFoodList(@RequestParam List<String> foodNameList, @PathVariable(name = "memberId") Long memberId ){

		List<FoodPrefer> updatedList = memberService.changeFoodPrefer(memberId, foodNameList);
		return BaseResponse.onSuccess(updatedList);
	}

}
