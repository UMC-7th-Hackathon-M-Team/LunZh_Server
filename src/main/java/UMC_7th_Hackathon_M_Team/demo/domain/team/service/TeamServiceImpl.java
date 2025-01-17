package UMC_7th_Hackathon_M_Team.demo.domain.team.service;

import UMC_7th_Hackathon_M_Team.demo.domain.team.dto.response.TeamResponse;
import UMC_7th_Hackathon_M_Team.demo.domain.team.entity.Team;
import UMC_7th_Hackathon_M_Team.demo.domain.team.mapper.TeamMapper;
import UMC_7th_Hackathon_M_Team.demo.domain.team.repository.TeamRepository;
import UMC_7th_Hackathon_M_Team.demo.domain.member.entity.Member;
import UMC_7th_Hackathon_M_Team.demo.domain.member.repository.MemberRepository;
import UMC_7th_Hackathon_M_Team.demo.global.exeption.CustomApiException;
import UMC_7th_Hackathon_M_Team.demo.global.exeption.ErrorCode;
import UMC_7th_Hackathon_M_Team.demo.global.validation.annotation.ParamValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements  TeamService{

    private final TeamMapper teamMapper;
    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public TeamResponse CreateTeam(String email,String name){
        ParamValidator.validationEmail(email);

        String teamCode = generateRandomString();

        Team newTeam = teamMapper.toTeam(name, teamCode);
        teamRepository.save(newTeam);

        Member member = memberRepository.findByEmail(email).orElseThrow(()-> new CustomApiException(ErrorCode.USER_NOT_FOUND));
        member.updateTeam(newTeam);
        memberRepository.save(member);

        return teamMapper.toTeamResponse(newTeam);
    }

    public  String generateRandomString() {
        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom RANDOM = new SecureRandom();

        StringBuilder stringBuilder = new StringBuilder(12);
        for (int i = 0; i < 12; i++) {
            int randomIndex = RANDOM.nextInt(CHARACTERS.length());
            stringBuilder.append(CHARACTERS.charAt(randomIndex));
        }
        return stringBuilder.toString();
    }

    @Override
    @Transactional
    public TeamResponse exitTeam(Long memberId){
        Member member = memberRepository.findById(memberId).orElseThrow(()-> new CustomApiException(ErrorCode.USER_NOT_FOUND));

        if(member.getTeam() == null){
            throw new CustomApiException(ErrorCode.USER_IS_NOT_IN_TEAM);
        }

        Team currentTeam = member.getTeam();

        member.updateTeam(null);
        memberRepository.save(member);

        return teamMapper.toTeamResponse(currentTeam);
    }

    @Override
    @Transactional
    public TeamResponse joinTeam(Long memberId, String teamCode){
        Member member = memberRepository.findById(memberId).orElseThrow(()-> new CustomApiException(ErrorCode.USER_NOT_FOUND));

        Team team = teamRepository.findByTeamCode(teamCode).orElseThrow(()->new CustomApiException(ErrorCode.TEAM_NOT_FOUND));

        member.updateTeam(team);
        memberRepository.save(member);

        return teamMapper.toTeamResponse(team);
    }
}
