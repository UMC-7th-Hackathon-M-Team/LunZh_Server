package UMC_7th_Hackathon_M_Team.demo.domain.group.repository;

import UMC_7th_Hackathon_M_Team.demo.domain.group.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
