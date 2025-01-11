package UMC_7th_Hackathon_M_Team.demo.domain.member.controller;

import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.request.MemberUpdateRequest;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.response.LoginResponse;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.response.MemberResponse;
import UMC_7th_Hackathon_M_Team.demo.domain.member.service.MemberService;
import UMC_7th_Hackathon_M_Team.demo.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "멤버 API", description = "멤버 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private MemberService memberService;

    @Operation(summary = "로그인 API")
    @PostMapping("/login")
    public BaseResponse<LoginResponse> login(@RequestParam(name = "로그인 할 멤버 이메일") String Email){
        return BaseResponse.onSuccess(memberService.login(Email));
    }

    @Operation(summary = "멤버 정보 수정 API")
    @PostMapping
    public BaseResponse<MemberResponse> updateMemberInfo(@RequestBody MemberUpdateRequest request){
        return BaseResponse.onSuccess(memberService.updateMemberInfo(request));
    }

}
