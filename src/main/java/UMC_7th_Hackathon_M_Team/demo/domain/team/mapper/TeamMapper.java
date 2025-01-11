package UMC_7th_Hackathon_M_Team.demo.domain.team.mapper;

import UMC_7th_Hackathon_M_Team.demo.domain.team.dto.response.TeamResponse;
import UMC_7th_Hackathon_M_Team.demo.domain.team.entity.Team;
import org.springframework.stereotype.Component;

@Component
public class TeamMapper {

    public Team toTeam(String name, String teamCode){
        return Team.builder()
                .name(name)
                .teamCode(teamCode)
                .build();
    }

    public TeamResponse toTeamResponse(Team team){
        return TeamResponse.builder()
                .id(team.getId())
                .groupCode(team.getTeamCode())
                .name(team.getName())
                .game(team.getGame())
                .build();
    }

}
