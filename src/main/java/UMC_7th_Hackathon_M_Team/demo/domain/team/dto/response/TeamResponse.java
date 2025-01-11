package UMC_7th_Hackathon_M_Team.demo.domain.team.dto.response;

import UMC_7th_Hackathon_M_Team.demo.domain.team.entity.enums.Game;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TeamResponse {
    private Long id;
    private String name;
    private String groupCode;
    private Game game;
}
