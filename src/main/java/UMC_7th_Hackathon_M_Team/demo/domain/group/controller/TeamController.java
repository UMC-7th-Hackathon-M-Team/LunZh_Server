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
    @PostMapping("/{memberId}")
    public BaseResponse<TeamResponse> CreateTeam(
            @Parameter(description = "수정할 이벤트 id") @PathVariable Long memberId
    ){
        return BaseResponse.onSuccess(teamService.exitTeam(memberId));
    }

}
