package UMC_7th_Hackathon_M_Team.demo.domain.group.controller;

import UMC_7th_Hackathon_M_Team.demo.domain.group.dto.response.TeamResponse;
import UMC_7th_Hackathon_M_Team.demo.domain.group.service.TeamService;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.request.MemberUpdateRequest;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.response.LoginResponse;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.response.MemberResponse;
import UMC_7th_Hackathon_M_Team.demo.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
    public BaseResponse<TeamResponse> CreateTeam(
            @Parameter(description = "그룹을 생성할 멤버 email") String email
    ){
        return BaseResponse.onSuccess(teamService.CreateTeam(email));
    }

    @Operation(summary = "그룹 탈퇴 API")
    @PostMapping("/exit")
    public BaseResponse<TeamResponse> exitTeam(
            @Parameter(description = "탈퇴할 멤버 id") @PathVariable Long memberId
    ){
        return BaseResponse.onSuccess(teamService.exitTeam(memberId));
    }

    @Operation(summary = "그룹 참여 API")
    @PostMapping("/participant")
    public BaseResponse<TeamResponse> joinTeam(
            @Parameter(description = "참여할 멤버 id") Long memberId,
            @Parameter(description = "참여할 그룹 코드") String teamCode
    ){
        return BaseResponse.onSuccess(teamService.joinTeam(memberId, teamCode));
    }

}
