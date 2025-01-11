package UMC_7th_Hackathon_M_Team.demo.domain.member.mapper;

import UMC_7th_Hackathon_M_Team.demo.domain.foodPrefer.entity.FoodPrefer;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.request.MemberUpdateRequest;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.response.LoginResponse;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.response.MemberResponse;
import UMC_7th_Hackathon_M_Team.demo.domain.member.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    public Member toMember(MemberUpdateRequest request){
        return Member.builder()
                .email(request.getEmail())
                .foodPreferList(request.getFoodPreferList())
                .nickname(request.getNickName())
                .build();
    }

    public LoginResponse toLoginResponse(Member member) {
        return LoginResponse.builder()
                .id(member.getId())
                .email(member.getEmail())
                .isFirstLogin(member.getIsFirstLogin())
                .build();
    }

    public MemberResponse MemberResponse(Member member, FoodPrefer foodPrefer){
        return MemberResponse.builder()
                .email(member.getEmail())
                .nickName(member.getNickname())
                .foodPrefer(foodPrefer)
                .build();
    }
}
