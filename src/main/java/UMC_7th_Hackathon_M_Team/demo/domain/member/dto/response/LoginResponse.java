package UMC_7th_Hackathon_M_Team.demo.domain.member.dto.response;

import UMC_7th_Hackathon_M_Team.demo.domain.foodPrefer.entity.FoodPrefer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class LoginResponse {
    private Long id;
    private String email;
    private Boolean isFirstLogin;
    private FoodPrefer foodPrefer;
}
