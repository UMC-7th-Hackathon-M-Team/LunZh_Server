package UMC_7th_Hackathon_M_Team.demo.domain.member.service;


import UMC_7th_Hackathon_M_Team.demo.domain.foodPrefer.entity.FoodPrefer;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.MemberRequestDTO;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.MemberResponseDTO;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.request.MemberUpdateRequest;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.response.LoginResponse;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.response.MemberResponse;
import UMC_7th_Hackathon_M_Team.demo.domain.member.entity.Member;

import java.util.List;

public interface MemberService {
    LoginResponse login(String email);
    MemberResponse updateMemberInfo(Long memberId, String nickName, List<String> preferFood);
	MemberResponseDTO.MyPageResponseDTO getMyPage(Long id);
	MemberResponseDTO.ChangeNameResponseDTO changeName(Long id, MemberRequestDTO.changeNameDto request);
	List<FoodPrefer> changeFoodPrefer(Long id, List<String> foodList);
	Member memberName(Long id);
	Boolean isMemberinGroup(Long memberId);
	String getGroupName(Long memberId);
}
