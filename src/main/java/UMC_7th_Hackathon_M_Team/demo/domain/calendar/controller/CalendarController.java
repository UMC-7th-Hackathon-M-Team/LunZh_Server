package UMC_7th_Hackathon_M_Team.demo.domain.calendar.controller;

import UMC_7th_Hackathon_M_Team.demo.domain.calendar.converter.CalendarConverter;
import UMC_7th_Hackathon_M_Team.demo.domain.calendar.dto.CalendarRequestDto;
import UMC_7th_Hackathon_M_Team.demo.domain.calendar.dto.CalendarResponseDto;
import UMC_7th_Hackathon_M_Team.demo.domain.calendar.entity.Calendar;
import UMC_7th_Hackathon_M_Team.demo.domain.calendar.service.CalendarService;
import UMC_7th_Hackathon_M_Team.demo.global.common.BaseEntity;
import UMC_7th_Hackathon_M_Team.demo.global.common.BaseResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendar")
@RequiredArgsConstructor
public class CalendarController {

    private final CalendarService calendarService;

    @GetMapping("/{teamId}")
    public BaseResponse<CalendarResponseDto.CalendarFoodResponseDTO> getCalendar(
            @PathVariable("teamId") Long teamId,
            @RequestParam("year") @Min(1900) Integer year,
            @RequestParam("month") @Min(1) @Max(12) Integer month
            ){
        CalendarRequestDto.CalendarFoodRequestDTO request = new CalendarRequestDto.CalendarFoodRequestDTO(year, month);
        List<Calendar> calendar = calendarService.getCalendar(teamId, request);
        return BaseResponse.onSuccess(CalendarConverter.toResponseDTO(calendar));
    }

}
