package UMC_7th_Hackathon_M_Team.demo.domain.group.service;

import UMC_7th_Hackathon_M_Team.demo.domain.group.dto.response.TeamResponse;

public interface TeamService {
    TeamResponse CreateTeam(String email);
    TeamResponse exitTeam(Long memberId);
    TeamResponse joinTeam(Long memberId, String teamCode);
}
