package UMC_7th_Hackathon_M_Team.demo.domain.member.entity;

import UMC_7th_Hackathon_M_Team.demo.domain.foodPrefer.entity.FoodPrefer;
import UMC_7th_Hackathon_M_Team.demo.domain.gameMember.entity.GameMember;
import UMC_7th_Hackathon_M_Team.demo.domain.Team.entity.Team;
import UMC_7th_Hackathon_M_Team.demo.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String nickname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<FoodPrefer> foodPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<GameMember> gameMemberList = new ArrayList<>();

}
