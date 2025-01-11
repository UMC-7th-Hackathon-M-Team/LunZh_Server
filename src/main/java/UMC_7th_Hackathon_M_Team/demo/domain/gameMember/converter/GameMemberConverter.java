package UMC_7th_Hackathon_M_Team.demo.domain.gameMember.converter;

import UMC_7th_Hackathon_M_Team.demo.domain.team.entity.Team;
import UMC_7th_Hackathon_M_Team.demo.domain.team.entity.enums.Game;
import UMC_7th_Hackathon_M_Team.demo.domain.gameMember.dto.GameMemberRequestDTO;
import UMC_7th_Hackathon_M_Team.demo.domain.gameMember.dto.GameMemberResponseDTO;
import UMC_7th_Hackathon_M_Team.demo.domain.gameMember.entity.GameMember;
import UMC_7th_Hackathon_M_Team.demo.domain.member.entity.Member;

import java.util.List;
import java.util.stream.Collectors;

public class GameMemberConverter {
    public static GameMemberResponseDTO.participateResponseDto participateDTO(Game game) {
        return GameMemberResponseDTO.participateResponseDto.builder()
                .game(game)
                .build();
    }

    public static GameMember toGameMember(GameMemberRequestDTO.memberResultRequestDTO request, Team team, Member member){
        return GameMember.builder()
                .member(member)
                .memberFood(request.getMemberFood())
                .result(request.getResult())
                .team(team)
                .build();
    }

    public static GameMemberResponseDTO.MemberResultResponseDTO toMemberResultResponseDTO(GameMember gameMember) {
        return GameMemberResponseDTO.MemberResultResponseDTO.builder()
                .memberId(gameMember.getMember().getId())
                .memberFood(gameMember.getMemberFood())
                .result(gameMember.getResult())
                .build();
    }

    public static GameMemberResponseDTO.RankResponseDTO toRankResponseDTO(List<GameMember> gameMemberList, String winningFood) {

        // 4. gameMemberList를 MemberDetailDTO로 변환
        List<GameMemberResponseDTO.MemberDetailDTO> memberDetails = gameMemberList.stream()
                .map(member -> GameMemberResponseDTO.MemberDetailDTO.builder()
                        .memberName("xx") // 현재 memberName이 없으므로 고정값 (수정 필요)
                        .result(member.getResult())
                        .memberFood(member.getMemberFood())
                        .build())
                .collect(Collectors.toList());

        // 5. 응답 DTO 생성
        return GameMemberResponseDTO.RankResponseDTO.builder()
                .winningFood(winningFood)
                .gameMemberList(memberDetails)
                .build();
    }


}
