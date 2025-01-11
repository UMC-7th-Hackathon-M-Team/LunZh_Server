package UMC_7th_Hackathon_M_Team.demo.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import UMC_7th_Hackathon_M_Team.demo.domain.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
