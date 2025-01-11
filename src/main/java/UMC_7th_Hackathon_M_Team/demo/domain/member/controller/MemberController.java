package UMC_7th_Hackathon_M_Team.demo.domain.member.controller;

import UMC_7th_Hackathon_M_Team.demo.domain.foodPrefer.entity.FoodPrefer;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.MemberRequestDTO;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.MemberResponseDTO;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.response.LoginResponse;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.response.MemberResponse;
import UMC_7th_Hackathon_M_Team.demo.domain.member.service.MemberService;
import UMC_7th_Hackathon_M_Team.demo.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @Parameters(value = {
            @Parameter(name = "memberId", description = "수정할 멤버 id"),
            @Parameter(name = "nickName", description = "입력할 닉네임"),
            @Parameter(name = "preferFood", description = "선호 음식 목록"),
    })
    public BaseResponse<MemberResponse> updateMemberInfo(
            @RequestParam(name = "memberId") Long memberId,
            @RequestParam(name = "nickName") String nickName,
            @RequestParam(name = "preferFood") List<String> preferFood
    ){
        return BaseResponse.onSuccess(memberService.updateMemberInfo(memberId, nickName, preferFood));
    }

    @Operation(
        summary = "마이페이지 조회 API",
        description = "마이페이지를 조회하는 API입니다. 닉네임, 음식 즐찾.",
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
    @GetMapping("/{memberId}")
    public BaseResponse<MemberResponseDTO.MyPageResponseDTO> myPage(@PathVariable(name = "memberId") Long memberId) {
        return BaseResponse.onSuccess(memberService.getMyPage(memberId));
    }

    @Operation(
        summary = "닉네임 변경 API",
        description = "닉네임 변경 API입니다.",
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
    @PostMapping("/nickname/{memberId}")
    public BaseResponse<MemberResponseDTO.ChangeNameResponseDTO> changeName(
            @RequestBody @Valid MemberRequestDTO.changeNameDto request,
            @PathVariable(name = "memberId") Long memberId
    ){
        return BaseResponse.onSuccess(memberService.changeName(memberId, request));
    }

    @Operation(
        summary = "즐겨찾는 음식 리스트 변경 API",
        description = "즐겨찾는 음식 리스트 변경 API입니다.",
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
    @PostMapping("/food/{memberId}")
    public BaseResponse<List<FoodPrefer>> changeFoodList(
            @RequestParam List<String> foodNameList,
            @PathVariable(name = "memberId") Long memberId
    ){
        List<FoodPrefer> updatedList = memberService.changeFoodPrefer(memberId, foodNameList);
        return BaseResponse.onSuccess(updatedList);
    }
}
