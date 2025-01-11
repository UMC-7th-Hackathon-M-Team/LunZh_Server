package UMC_7th_Hackathon_M_Team.demo.domain.member.entity;

import UMC_7th_Hackathon_M_Team.demo.domain.foodPrefer.entity.FoodPrefer;
import UMC_7th_Hackathon_M_Team.demo.domain.gameMember.entity.GameMember;
import UMC_7th_Hackathon_M_Team.demo.domain.team.entity.Team;
import UMC_7th_Hackathon_M_Team.demo.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String nickname;

    @Column
    private Boolean isFirstLogin = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<FoodPrefer> foodPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<GameMember> gameMemberList = new ArrayList<>();

    public void changeNickName(String nickname) {
        this.nickname = nickname;

    public void updateIsFirstLogin(){
        this.isFirstLogin = true;
    }

    public void updateMemberInfo(String nickname, List<FoodPrefer> foodPreferList){
        this.nickname = nickname;
        this.foodPreferList = foodPreferList;
    }

    public void updateTeam(Team team){
        this.team = team;
    }
}
