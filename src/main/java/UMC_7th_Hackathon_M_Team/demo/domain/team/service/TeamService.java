package UMC_7th_Hackathon_M_Team.demo.domain.team.service;

import UMC_7th_Hackathon_M_Team.demo.domain.team.dto.response.TeamResponse;

public interface TeamService {
    TeamResponse CreateTeam(String email, String name);
    TeamResponse exitTeam(Long memberId);
    TeamResponse joinTeam(Long memberId, String teamCode);
}
