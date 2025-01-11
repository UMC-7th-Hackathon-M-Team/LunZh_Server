package UMC_7th_Hackathon_M_Team.demo.domain.calendar.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CalendarRequestDto {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CalendarFoodRequestDTO {
        @NotNull
        @Min(1900)
        Integer year; // 연도

        @NotNull
        @Min(1)
        @Max(12)
        Integer month; // 월
    }
}
