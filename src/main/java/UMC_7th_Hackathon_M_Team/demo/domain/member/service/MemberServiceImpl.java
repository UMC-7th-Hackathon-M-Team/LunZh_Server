package UMC_7th_Hackathon_M_Team.demo.domain.member.service;

import UMC_7th_Hackathon_M_Team.demo.domain.foodPrefer.entity.FoodPrefer;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.request.MemberUpdateRequest;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.response.LoginResponse;
import UMC_7th_Hackathon_M_Team.demo.domain.member.dto.response.MemberResponse;
import UMC_7th_Hackathon_M_Team.demo.domain.member.entity.Member;
import UMC_7th_Hackathon_M_Team.demo.domain.member.mapper.MemberMapper;
import UMC_7th_Hackathon_M_Team.demo.domain.member.repository.MemberRepository;
import UMC_7th_Hackathon_M_Team.demo.global.exeption.CustomApiException;
import UMC_7th_Hackathon_M_Team.demo.global.exeption.ErrorCode;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Override
    @Transactional
    public LoginResponse login(String email){
        Member member = memberRepository.findMemberByEmail(email);

        return memberMapper.toLoginResponse(member);
    }

    @Override
    @Transactional
    public MemberResponse updateMemberInfo(MemberUpdateRequest request){
        Member member = memberMapper.toMember(request);
        member.updateIsFirstLogin();
        memberRepository.save(member);

        FoodPrefer randomFoodPrefer = getRandomFoodPrefer(request.getFoodPreferList());

        return memberMapper.MemberResponse(member,randomFoodPrefer);
    }

    private FoodPrefer getRandomFoodPrefer(List<FoodPrefer> foodPreferList) {
        if (foodPreferList == null || foodPreferList.isEmpty()) {
            throw new CustomApiException(ErrorCode.FOOD_PREFER_NOT_FOUND);
        }
        Random random = new Random();
        int randomIndex = random.nextInt(foodPreferList.size());
        return foodPreferList.get(randomIndex);
    }

}
