package UMC_7th_Hackathon_M_Team.demo.domain.calendar.converter;

import UMC_7th_Hackathon_M_Team.demo.domain.calendar.dto.CalendarResponseDto;
import UMC_7th_Hackathon_M_Team.demo.domain.calendar.entity.Calendar;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CalendarConverter {

    public static CalendarResponseDto.DailyFoodDTO toDailyFoodDTO(Calendar entity) {
        return CalendarResponseDto.DailyFoodDTO.builder()
                .date(entity.getDate().toString())
                .food(entity.getFood())
                .build();
    }

    public static CalendarResponseDto.CalendarFoodResponseDTO toResponseDTO(List<Calendar> calendarList) {
        List<CalendarResponseDto.DailyFoodDTO> dailyFoodDTOs = calendarList.stream()
                .filter(calendar -> calendar.getFood() != null)
                .map(CalendarConverter::toDailyFoodDTO)
                .sorted(Comparator.comparing(CalendarResponseDto.DailyFoodDTO::getDate)) // 날짜 기준 오름차순 정렬
                .collect(Collectors.toList());

        return CalendarResponseDto.CalendarFoodResponseDTO.builder()
                .dailyFoodDTOList(dailyFoodDTOs)
                .build();
    }
}
