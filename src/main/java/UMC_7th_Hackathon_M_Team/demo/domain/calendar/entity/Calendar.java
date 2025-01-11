package UMC_7th_Hackathon_M_Team.demo.domain.calendar.entity;

import java.time.LocalDate;

import UMC_7th_Hackathon_M_Team.demo.domain.team.entity.Team;
import UMC_7th_Hackathon_M_Team.demo.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Calendar extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private LocalDate date;

	@Column
	private String food;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "teamId")
	private Team team;
}
