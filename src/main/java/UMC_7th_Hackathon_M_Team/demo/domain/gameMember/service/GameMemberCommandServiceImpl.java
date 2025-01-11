package UMC_7th_Hackathon_M_Team.demo.domain.gameMember.service;

import UMC_7th_Hackathon_M_Team.demo.domain.Team.entity.Team;
import UMC_7th_Hackathon_M_Team.demo.domain.Team.entity.enums.Game;
import UMC_7th_Hackathon_M_Team.demo.domain.Team.repository.TeamRepository;
import UMC_7th_Hackathon_M_Team.demo.domain.gameMember.converter.GameMemberConverter;
import UMC_7th_Hackathon_M_Team.demo.domain.gameMember.dto.GameMemberRequestDTO;
import UMC_7th_Hackathon_M_Team.demo.domain.gameMember.entity.GameMember;
import UMC_7th_Hackathon_M_Team.demo.domain.gameMember.repository.GameMemberRepository;
import UMC_7th_Hackathon_M_Team.demo.domain.member.entity.Member;
import UMC_7th_Hackathon_M_Team.demo.domain.member.repository.MemberRepository;
import UMC_7th_Hackathon_M_Team.demo.global.exeption.CustomApiException;
import UMC_7th_Hackathon_M_Team.demo.global.exeption.ErrorCode;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class GameMemberCommandServiceImpl implements GameMemberCommandService{

    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;
    private final GameMemberRepository gameMemberRepository;
    @Override
    @Transactional
    public Game participate(Long teamId, Long memberId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new CustomApiException(ErrorCode.TEAM_NOT_FOUND));
        if (team.getGame() == null || team.getGame() == Game.Complete) {
            Game randomGame = getRandomGame();
            teamRepository.save(team);
            return randomGame;
        } else {
            return team.getGame();
        }
    }

    @Override
    @Transactional
    public GameMember gameResult(Long teamId, Long memberId, GameMemberRequestDTO.memberResultRequestDTO request) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new CustomApiException(ErrorCode.TEAM_NOT_FOUND));
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new CustomApiException(ErrorCode.USER_NOT_FOUND));
        GameMember gameMember = GameMemberConverter.toGameMember(request, team, member);

        return gameMemberRepository.save(gameMember);
    }

    private Game getRandomGame() {
        List<Game> games = Arrays.asList(Game.A, Game.B, Game.C); // A, B, C만 포함
        Random random = new Random();
        return games.get(random.nextInt(games.size()));
    }

    // 게임 로직 처리
    private void GameLogic(Game game, Integer time) {
        // Game.A => 랜덤은 최종으로 반환
        if (game == Game.B) { // 페이커

        } else if (game == Game.C) { // 시간 맞추기

        }
    }
}