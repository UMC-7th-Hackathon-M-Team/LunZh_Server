package UMC_7th_Hackathon_M_Team.demo.domain.calendar.dto;

import lombok.*;

import java.util.List;

public class CalendarResponseDto {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CalendarFoodResponseDTO {
        List<DailyFoodDTO> dailyFoodDTOList;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DailyFoodDTO{
        String date;
        String food;
    }
}
