package UMC_7th_Hackathon_M_Team.demo.domain.member.repository;

import UMC_7th_Hackathon_M_Team.demo.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Member findMemberByEmail(String email);
}
