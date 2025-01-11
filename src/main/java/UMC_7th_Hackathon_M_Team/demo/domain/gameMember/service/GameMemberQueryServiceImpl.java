package UMC_7th_Hackathon_M_Team.demo.domain.gameMember.service;

import UMC_7th_Hackathon_M_Team.demo.domain.calendar.entity.Calendar;
import UMC_7th_Hackathon_M_Team.demo.domain.calendar.repository.CalendarRepository;
import UMC_7th_Hackathon_M_Team.demo.domain.team.entity.Team;
import UMC_7th_Hackathon_M_Team.demo.domain.team.entity.enums.Game;
import UMC_7th_Hackathon_M_Team.demo.domain.gameMember.entity.GameMember;
import UMC_7th_Hackathon_M_Team.demo.domain.gameMember.repository.GameMemberRepository;
import UMC_7th_Hackathon_M_Team.demo.domain.team.repository.TeamRepository;
import UMC_7th_Hackathon_M_Team.demo.global.exeption.CustomApiException;
import UMC_7th_Hackathon_M_Team.demo.global.exeption.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GameMemberQueryServiceImpl implements GameMemberQueryService{
    private final GameMemberRepository gameMemberRepository;
    private final TeamRepository teamRepository;
    private final CalendarRepository calendarRepository;
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
        // 4. 정렬된 첫 번째 GameMember에서 food 값 가져오기
        String food = gameMemberList.isEmpty() ? null : gameMemberList.get(0).getMemberFood();

        // 5. Calendar 엔티티 생성 및 저장
        if (food != null) {
            Calendar calendar = Calendar.builder()
                    .team(team)
                    .date(LocalDate.now()) // 현재 날짜 저장
                    .food(food) // 첫 번째 음식 저장
                    .build();
            calendarRepository.save(calendar);
        }

        // team Complete 변환
        team.setGame(Game.Complete);
        teamRepository.save(team);
        return gameMemberList;
    }

}
