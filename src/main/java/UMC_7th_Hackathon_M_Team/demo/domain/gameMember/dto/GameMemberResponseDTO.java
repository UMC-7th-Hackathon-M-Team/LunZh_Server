package UMC_7th_Hackathon_M_Team.demo.domain.gameMember.dto;

import UMC_7th_Hackathon_M_Team.demo.domain.Team.entity.enums.Game;
import lombok.*;

public class GameMemberResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class participateResponseDto{
        Game game;
    }

    public static class MemberResultResponseDTO{
        private Long memberId;
        private String memberFood;
        private int result;
    }


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RankResponseDTO {

    }
}
