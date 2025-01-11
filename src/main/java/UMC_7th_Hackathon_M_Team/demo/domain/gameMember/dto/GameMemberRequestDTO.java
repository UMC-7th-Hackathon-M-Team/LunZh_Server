package UMC_7th_Hackathon_M_Team.demo.domain.gameMember.dto;

import UMC_7th_Hackathon_M_Team.demo.domain.team.entity.enums.Game;
import lombok.Getter;

public class GameMemberRequestDTO {

    @Getter
    public static class memberResultRequestDTO{
        Game game;
        String memberFood;
        Integer result;
    }
    @Getter
    public static class RankRequestDTO{
        Game game;
    }
}
