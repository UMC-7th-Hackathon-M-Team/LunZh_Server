package UMC_7th_Hackathon_M_Team.demo.domain.gameMember.dto;

import UMC_7th_Hackathon_M_Team.demo.domain.Team.entity.enums.Game;
import UMC_7th_Hackathon_M_Team.demo.domain.gameMember.entity.GameMember;
import lombok.*;

import java.util.List;

public class GameMemberResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class participateResponseDto{
        Game game;
    }


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberResultResponseDTO{
        Long memberId;
        String memberFood;
        Integer result;
    }


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RankResponseDTO {
        String winningFood;
        List<MemberDetailDTO> gameMemberList;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public  static class MemberDetailDTO{
        String memberName;
        Integer result;
        String memberFood;
    }
}
