package UMC_7th_Hackathon_M_Team.demo.domain.gameMember.converter;

import UMC_7th_Hackathon_M_Team.demo.domain.Team.entity.Team;
import UMC_7th_Hackathon_M_Team.demo.domain.Team.entity.enums.Game;
import UMC_7th_Hackathon_M_Team.demo.domain.gameMember.dto.GameMemberRequestDTO;
import UMC_7th_Hackathon_M_Team.demo.domain.gameMember.dto.GameMemberResponseDTO;
import UMC_7th_Hackathon_M_Team.demo.domain.gameMember.entity.GameMember;
import UMC_7th_Hackathon_M_Team.demo.domain.member.entity.Member;

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
}
