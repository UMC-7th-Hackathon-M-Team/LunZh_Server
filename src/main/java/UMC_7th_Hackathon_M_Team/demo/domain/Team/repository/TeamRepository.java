package UMC_7th_Hackathon_M_Team.demo.domain.Team.repository;

import UMC_7th_Hackathon_M_Team.demo.domain.Team.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
