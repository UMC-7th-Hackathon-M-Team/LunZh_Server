package UMC_7th_Hackathon_M_Team.demo.domain.gameMember.service;

import UMC_7th_Hackathon_M_Team.demo.domain.gameMember.dto.GameMemberRequestDTO;
import UMC_7th_Hackathon_M_Team.demo.domain.gameMember.entity.GameMember;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GameMemberQueryService {
    List<GameMember> getGameMemberList(Long teamId);
}
