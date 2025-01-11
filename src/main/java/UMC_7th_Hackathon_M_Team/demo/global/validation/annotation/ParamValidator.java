package UMC_7th_Hackathon_M_Team.demo.global.validation.annotation;
import UMC_7th_Hackathon_M_Team.demo.global.exeption.CustomApiException;
import UMC_7th_Hackathon_M_Team.demo.global.exeption.ErrorCode;

import java.util.regex.Pattern;

public class ParamValidator {

    public static void validationEmail(String email) {
        String EMAIL_REGEX = "^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,6}$";
        Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new CustomApiException(ErrorCode.INVALID_EMAIL);
        }
    }
}
