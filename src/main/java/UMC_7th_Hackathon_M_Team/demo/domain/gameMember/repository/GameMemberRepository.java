package UMC_7th_Hackathon_M_Team.demo.domain.gameMember.repository;

import UMC_7th_Hackathon_M_Team.demo.domain.gameMember.entity.GameMember;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameMemberRepository extends JpaRepository<GameMember, Long> {
    List<GameMember> findByTeamId(Long teamId);
}
