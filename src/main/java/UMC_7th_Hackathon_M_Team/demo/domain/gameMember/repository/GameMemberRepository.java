package UMC_7th_Hackathon_M_Team.demo.domain.gameMember.repository;

import UMC_7th_Hackathon_M_Team.demo.domain.gameMember.entity.GameMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameMemberRepository extends JpaRepository<GameMember, Long> {
}
