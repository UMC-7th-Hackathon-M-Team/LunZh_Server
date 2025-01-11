package UMC_7th_Hackathon_M_Team.demo.domain.calendar.service;

import UMC_7th_Hackathon_M_Team.demo.domain.calendar.converter.CalendarConverter;
import UMC_7th_Hackathon_M_Team.demo.domain.calendar.dto.CalendarRequestDto;
import UMC_7th_Hackathon_M_Team.demo.domain.calendar.dto.CalendarResponseDto;
import UMC_7th_Hackathon_M_Team.demo.domain.calendar.entity.Calendar;
import UMC_7th_Hackathon_M_Team.demo.domain.calendar.repository.CalendarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CalendarService {

    private final CalendarRepository calendarRepository;

    public List<Calendar> getCalendar(Long teamId, CalendarRequestDto.CalendarFoodRequestDTO request){
        YearMonth yearMonth = YearMonth.of(request.getYear(), request.getMonth());
        LocalDate startDate = yearMonth.atDay(1); // 해당 월의 첫째 날
        LocalDate endDate = yearMonth.atEndOfMonth(); // 해당 월의 마지막 날

        List<Calendar> calendarList = calendarRepository.findByGroupIdAndDateRange(teamId, startDate, endDate);
        return calendarList;
    }

}
