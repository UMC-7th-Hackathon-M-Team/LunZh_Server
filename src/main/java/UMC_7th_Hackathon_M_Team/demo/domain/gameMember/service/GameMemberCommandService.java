package UMC_7th_Hackathon_M_Team.demo.domain.gameMember.service;

import UMC_7th_Hackathon_M_Team.demo.domain.team.entity.enums.Game;
import UMC_7th_Hackathon_M_Team.demo.domain.gameMember.dto.GameMemberRequestDTO;
import UMC_7th_Hackathon_M_Team.demo.domain.gameMember.entity.GameMember;

public interface GameMemberCommandService {
    public Game participate(Long groupId, Long memberId);

    public GameMember gameResult(Long TeamId, Long memberId, GameMemberRequestDTO.memberResultRequestDTO request);
}
