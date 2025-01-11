package UMC_7th_Hackathon_M_Team.demo.domain.team.entity;

import java.util.ArrayList;
import java.util.List;

import UMC_7th_Hackathon_M_Team.demo.domain.calendar.entity.Calendar;
import UMC_7th_Hackathon_M_Team.demo.domain.gameMember.entity.GameMember;
import UMC_7th_Hackathon_M_Team.demo.domain.team.entity.enums.Game;
import UMC_7th_Hackathon_M_Team.demo.domain.member.entity.Member;
import UMC_7th_Hackathon_M_Team.demo.global.common.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Team extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String teamCode;

	@Enumerated(value = EnumType.STRING)
	@Column
	private Game game;

	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
	private List<Member> members = new ArrayList<>();

	@OneToOne(mappedBy = "team", cascade = CascadeType.ALL)
	private Calendar calendar;

	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
	private List<GameMember> gameMembers = new ArrayList<>();

	public void setGame(Game game) {
		this.game = game;
	}
}
