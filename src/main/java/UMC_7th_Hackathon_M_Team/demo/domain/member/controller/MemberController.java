package UMC_7th_Hackathon_M_Team.demo.domain.member.controller;

import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.request.MemberUpdateRequest;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.response.LoginResponse;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.response.MemberResponse;
import UMC_7th_Hackathon_M_Team.demo.domain.member.service.MemberService;
import UMC_7th_Hackathon_M_Team.demo.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "멤버 API", description = "멤버 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @Operation(summary = "로그인 API")
    @PostMapping("/login")
    @Parameters(value = {
            @Parameter(name = "email", description = "로그인할 멤버 이메일"),
    })
    public BaseResponse<LoginResponse> login(@RequestParam(name = "email") String email){
        return BaseResponse.onSuccess(memberService.login(email));
    }

    @Operation(summary = "멤버 정보 수정 API")
    @PostMapping
    public BaseResponse<MemberResponse> updateMemberInfo(@RequestBody MemberUpdateRequest request){
        return BaseResponse.onSuccess(memberService.updateMemberInfo(request));
    }

}
