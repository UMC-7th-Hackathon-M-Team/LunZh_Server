package UMC_7th_Hackathon_M_Team.demo.domain.test.controller;

import UMC_7th_Hackathon_M_Team.demo.global.common.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/example")
    public BaseResponse<String> example() {
        return BaseResponse.onSuccess( "예시 API");
    }
}