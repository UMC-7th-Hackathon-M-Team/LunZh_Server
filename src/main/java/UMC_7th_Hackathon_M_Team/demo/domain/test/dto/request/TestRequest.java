package UMC_7th_Hackathon_M_Team.demo.domain.test.dto.request;

import UMC_7th_Hackathon_M_Team.demo.global.validation.annotation.TestAnnotation;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TestRequest {
    @NotBlank(message = "아이디는 필수 입력값입니다.")
    private String id;

    @TestAnnotation
    private String name;

    @Min(value = 1, message = "나이는 0보다 커야합니다.")
    private int age;
}