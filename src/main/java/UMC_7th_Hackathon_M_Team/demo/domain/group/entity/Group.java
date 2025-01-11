package UMC_7th_Hackathon_M_Team.demo.domain.group.entity;

import java.util.ArrayList;
import java.util.List;

import UMC_7th_Hackathon_M_Team.demo.domain.calendar.entity.Calendar;
import UMC_7th_Hackathon_M_Team.demo.domain.group.entity.enums.Game;
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
public class Group extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String groupCode;

	@Enumerated(value = EnumType.STRING)
	@Column
	private Game game;

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<Member> members = new ArrayList<>();

	@OneToOne(mappedBy = "group", cascade = CascadeType.ALL)
	private Calendar calendar;
}
