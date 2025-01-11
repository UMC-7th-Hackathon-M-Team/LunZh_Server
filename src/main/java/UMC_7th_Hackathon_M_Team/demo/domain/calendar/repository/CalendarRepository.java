package UMC_7th_Hackathon_M_Team.demo.domain.calendar.repository;

import UMC_7th_Hackathon_M_Team.demo.domain.calendar.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CalendarRepository extends JpaRepository<Calendar, Long> {
    @Query("SELECT c FROM Calendar c WHERE c.team.id = :teamId AND c.date BETWEEN :startDate AND :endDate AND c.food IS NOT NULL")
    List<Calendar> findByGroupIdAndDateRange(
            @Param("teamId") Long teamId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);
}
