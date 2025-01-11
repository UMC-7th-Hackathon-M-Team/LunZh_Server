package UMC_7th_Hackathon_M_Team.demo.domain.group.controller;

import UMC_7th_Hackathon_M_Team.demo.domain.group.dto.response.TeamResponse;
import UMC_7th_Hackathon_M_Team.demo.domain.group.service.TeamService;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.request.MemberUpdateRequest;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.response.LoginResponse;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.response.MemberResponse;
import UMC_7th_Hackathon_M_Team.demo.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "그룹 API", description = "그룹 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/groups")
public class TeamController {

    private final TeamService teamService;

    @Operation(summary = "그룹 생성 API")
    @PostMapping
    @Parameters(value = {
            @Parameter(name = "email", description = "그룹 생성하는 멤버 이메일"),
            @Parameter(name = "name", description = "생성할 그룹 이름")
    })
    public BaseResponse<TeamResponse> CreateTeam(
            @RequestParam(name = "email") String email,
            @RequestParam(name = "name") String name
    ){
        return BaseResponse.onSuccess(teamService.CreateTeam(email,name));
    }

    @Operation(summary = "그룹 탈퇴 API")
    @PostMapping("/exit")
    @Parameters(value = {
            @Parameter(name = "memberId", description = "탈퇴할 멤버 Id"),
    })
    public BaseResponse<TeamResponse> exitTeam(
            @RequestParam(name = "memberId") Long memberId
    ){
        return BaseResponse.onSuccess(teamService.exitTeam(memberId));
    }

    @Operation(summary = "그룹 참여 API")
    @PostMapping("/participant")
    @Parameters(value = {
            @Parameter(name = "memberId", description = "참여할 멤버 Id"),
            @Parameter(name = "teamCode", description = "참여할 그룹의 코드")
    })
    public BaseResponse<TeamResponse> joinTeam(
            @RequestParam(name = "memberId") Long memberId,
            @RequestParam(name = "teamCode") String teamCode
    ){
        return BaseResponse.onSuccess(teamService.joinTeam(memberId, teamCode));
    }

}
