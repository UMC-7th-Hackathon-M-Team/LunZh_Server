package UMC_7th_Hackathon_M_Team.demo.domain.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import UMC_7th_Hackathon_M_Team.demo.domain.member.converter.MemberConverter;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.MemberResponseDTO;
import UMC_7th_Hackathon_M_Team.demo.domain.member.entity.Member;
import UMC_7th_Hackathon_M_Team.demo.domain.member.service.MemberService;
import UMC_7th_Hackathon_M_Team.demo.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HomeController {

	private final MemberService memberService;

	@Operation(
		summary = "홈 API",
		description = "홈 API입니다. 닉네임, 그룹이 있는 지",
		responses = {
			@io.swagger.v3.oas.annotations.responses.ApiResponse(
				responseCode = "200",
				description = "OK, 성공",
				content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json")
			)
		},
		parameters = {
			@Parameter(name = "memberId", description = "나의 아이디, path variable 입니다!", in = io.swagger.v3.oas.annotations.enums.ParameterIn.PATH)
		}
	)
	@GetMapping("/home/{memberId}")
	public BaseResponse<MemberResponseDTO.HomeResponseDTO> home(@PathVariable(name = "memberId") Long memberId) {

		Member member = memberService.memberName(memberId);
		Boolean hasGroup = memberService.isMemberinGroup(memberId);
		String groupName = memberService.getGroupName(memberId);

		return BaseResponse.onSuccess(MemberConverter.toHomeResponseDTO(hasGroup,member,groupName));

	}

}
