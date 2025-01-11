package UMC_7th_Hackathon_M_Team.demo.domain.member.service;

import UMC_7th_Hackathon_M_Team.demo.domain.food.entity.Food;
import UMC_7th_Hackathon_M_Team.demo.domain.food.mapper.FoodPreferMapper;
import UMC_7th_Hackathon_M_Team.demo.domain.food.repository.FoodRepository;
import UMC_7th_Hackathon_M_Team.demo.domain.foodPrefer.entity.FoodPrefer;
import UMC_7th_Hackathon_M_Team.demo.domain.foodPrefer.repository.FoodPreferRepository;
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
    private final FoodPreferMapper foodPreferMapper;
    private final FoodRepository foodRepository;

    @Override
    @Transactional
    public LoginResponse login(String email){
        Member member = memberRepository.findMemberByEmail(email);

        if (member == null) {
            member = createMember(email);
        }
        return memberMapper.toLoginResponse(member);
    }

    public Member createMember(String email){
        Member newMember = memberMapper.toMember(email);
        return memberRepository.save(newMember);
    }

    @Override
    @Transactional
    public MemberResponse updateMemberInfo(Long memberId, String nickName, List<String> preferFood){
        Member member = memberRepository.findById(memberId).orElseThrow(()->new CustomApiException(ErrorCode.USER_NOT_FOUND));

        List<FoodPrefer> foodPreferList = preferFood.stream()
                .map(foodName -> {
                    Food food = foodRepository.findByName(foodName)
                            .orElseThrow(() -> new CustomApiException(ErrorCode.FOOD_NOT_FOUND));

                    return foodPreferMapper.toFoodPrefer(member, food);
                })
                .toList();

        member.updateMemberInfo(nickName, foodPreferList);
        member.updateIsFirstLogin();
        memberRepository.save(member);

        FoodPrefer randomFoodPrefer = getRandomFoodPrefer(foodPreferList);

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
