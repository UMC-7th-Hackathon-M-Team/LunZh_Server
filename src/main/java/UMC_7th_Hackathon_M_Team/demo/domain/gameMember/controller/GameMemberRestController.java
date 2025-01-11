package UMC_7th_Hackathon_M_Team.demo.domain.gameMember.controller;


import UMC_7th_Hackathon_M_Team.demo.domain.gameMember.converter.GameMemberConverter;
import UMC_7th_Hackathon_M_Team.demo.domain.gameMember.dto.GameMemberRequestDTO;
import UMC_7th_Hackathon_M_Team.demo.domain.gameMember.dto.GameMemberResponseDTO;
import UMC_7th_Hackathon_M_Team.demo.domain.gameMember.entity.GameMember;
import UMC_7th_Hackathon_M_Team.demo.domain.gameMember.service.GameMemberCommandService;
import UMC_7th_Hackathon_M_Team.demo.domain.team.entity.enums.Game;
import UMC_7th_Hackathon_M_Team.demo.domain.gameMember.service.GameMemberQueryService;
import UMC_7th_Hackathon_M_Team.demo.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/game")
public class GameMemberRestController {
    private final GameMemberCommandService gameMemberCommandService;
    private final GameMemberQueryService gameMemberQueryService;
    @GetMapping("/{teamId}/{memberId}")
    @Operation(summary = "게임에 참가하는 API",description = "그룹에 랜덤으로 배정된 게임을 반환해주는 API 이다.")
    public BaseResponse<GameMemberResponseDTO.participateResponseDto> participate(
            @PathVariable("teamId") Long groupId,
            @PathVariable("memberId") Long memberId
    ){
        Game game = gameMemberCommandService.participate(groupId, memberId);

        return BaseResponse.onSuccess(GameMemberConverter.participateDTO(game));
    }

    @PostMapping("/result/{teamId}/{memberId}")
    @Operation(summary = "개인 게임 결과 반환 API",description = "각각의 멤버가 게임이 끝난 경우 결과를 받아오는 API")
    public BaseResponse<GameMemberResponseDTO.MemberResultResponseDTO> memberResult(
            @PathVariable("teamId") Long teamId,
            @PathVariable("memberId") Long memberId,
            @RequestBody @Valid GameMemberRequestDTO.memberResultRequestDTO request
            ){
        GameMember gameMember = gameMemberCommandService.gameResult(teamId, memberId, request);
        return BaseResponse.onSuccess(GameMemberConverter.toMemberResultResponseDTO(gameMember));
    }

    @GetMapping("/team-result/{teamId}")
    @Operation(summary = "멤버 랭킹 반환, 메뉴 선정 API", description = "게임 결과 반환 후, 메뉴를 캘린더에 등록하는 API")
    public BaseResponse<GameMemberResponseDTO.RankResponseDTO> teamRank(@PathVariable("teamId") Long teamId)
    {
        List<GameMember> gameMemberList = gameMemberQueryService.getGameMemberList(teamId);
        String winningFood = gameMemberList.isEmpty() ? null : gameMemberList.get(0).getMemberFood();
        return BaseResponse.onSuccess(GameMemberConverter.toRankResponseDTO(gameMemberList, winningFood));
    }
}
