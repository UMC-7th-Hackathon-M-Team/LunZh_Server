package UMC_7th_Hackathon_M_Team.demo.domain.test.controller;

import UMC_7th_Hackathon_M_Team.demo.global.common.BaseResponse;
import UMC_7th_Hackathon_M_Team.demo.global.exeption.CustomApiException;
import UMC_7th_Hackathon_M_Team.demo.global.exeption.ErrorCode;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/example")
    public BaseResponse<String> example() {
        return BaseResponse.onSuccess( "예시 API");
    }

    @Operation(summary = "에러 핸들러 테스트 API", description = "직접 정의한 에러에 대한 예외 처리 테스트 API")
    @PostMapping("/customException")
    public BaseResponse<Object> throwCustomException() {
        throw new CustomApiException(ErrorCode.USER_NOT_FOUND);
    }

    @Operation(summary = "에러 핸들러 테스트 API", description = "ConstraintViolationException 및 MethodArgumentNotValidException에 대한 예외 처리 테스트 API")
    @PostMapping("/methodArgumentNotValid")
    public BaseResponse<String> throwMethodArgumentNotValidException(@Valid @RequestBody TestRequest request) {
        return BaseResponse.onSuccess("테스트 API");
    }
}