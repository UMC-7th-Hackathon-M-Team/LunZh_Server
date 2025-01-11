package UMC_7th_Hackathon_M_Team.demo.domain.member.service;

import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.request.MemberUpdateRequest;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.response.LoginResponse;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.response.MemberResponse;

import java.util.List;

public interface MemberService {
    LoginResponse login(String email);
    MemberResponse updateMemberInfo(Long memberId, String nickName, List<String> preferFood);

}
