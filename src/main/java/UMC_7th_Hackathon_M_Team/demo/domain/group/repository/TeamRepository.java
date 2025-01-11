package UMC_7th_Hackathon_M_Team.demo.domain.group.repository;

import UMC_7th_Hackathon_M_Team.demo.domain.group.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Optional<Team> findByTeamCode(String teamCode);
}
