package UMC_7th_Hackathon_M_Team.demo.domain.member.dto.request;

import UMC_7th_Hackathon_M_Team.demo.domain.foodPrefer.entity.FoodPrefer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberUpdateRequest {
    private Long id;
    private String email;
    private List<FoodPrefer> foodPreferList;
    private String nickName;
}
