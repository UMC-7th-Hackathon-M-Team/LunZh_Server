package UMC_7th_Hackathon_M_Team.demo.domain.gameMember.service;

import UMC_7th_Hackathon_M_Team.demo.domain.Team.entity.Team;
import UMC_7th_Hackathon_M_Team.demo.domain.Team.entity.enums.Game;
import UMC_7th_Hackathon_M_Team.demo.domain.Team.repository.TeamRepository;
import UMC_7th_Hackathon_M_Team.demo.domain.gameMember.dto.GameMemberRequestDTO;
import UMC_7th_Hackathon_M_Team.demo.domain.gameMember.entity.GameMember;
import UMC_7th_Hackathon_M_Team.demo.domain.gameMember.repository.GameMemberRepository;
import UMC_7th_Hackathon_M_Team.demo.global.exeption.CustomApiException;
import UMC_7th_Hackathon_M_Team.demo.global.exeption.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GameMemberQueryServiceImpl implements GameMemberQueryService{
    private final GameMemberRepository gameMemberRepository;
    private final TeamRepository teamRepository;
    @Override
    @Transactional
    public List<GameMember> getGameMemberList(Long teamId) {

        List<GameMember> gameMemberList = gameMemberRepository.findByTeamId(teamId);
        Game gameType = teamRepository.findById(teamId)
                .orElseThrow(() -> new CustomApiException(ErrorCode.TEAM_NOT_FOUND)).getGame();
        if (gameType == Game.A){
            Collections.shuffle(gameMemberList);
        } else if (gameType == Game.B || gameType == Game.C) {
            gameMemberList.sort(Comparator.comparingInt(GameMember::getResult));
        }
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new CustomApiException(ErrorCode.TEAM_NOT_FOUND));
        team.setGame(Game.Complete);
        teamRepository.save(team);
        return gameMemberList;
    }

}
