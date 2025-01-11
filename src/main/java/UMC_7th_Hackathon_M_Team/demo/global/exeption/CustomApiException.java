package UMC_7th_Hackathon_M_Team.demo.global.exeption;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomApiException extends RuntimeException{
    private ErrorCode errorCode;
}