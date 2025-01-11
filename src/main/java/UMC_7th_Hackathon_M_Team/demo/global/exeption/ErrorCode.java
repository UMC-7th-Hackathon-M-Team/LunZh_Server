package UMC_7th_Hackathon_M_Team.demo.global.exeption;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청입니다."),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON401", "인증이 필요합니다."),
    FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON402", "금지된 요청입니다."),
    UNAUTHORIZED_MODIFY(HttpStatus.BAD_REQUEST, "COMMON403", "수정, 삭제 권한이 없습니다."),
    USER_NOT_ADMIN(HttpStatus.UNAUTHORIZED, "COMMON404", "관리자만 사용 가능한 API입니다."),
    UNKNOWN_INQUIRY_TYPE(HttpStatus.BAD_REQUEST, "COMMON405", "알 수 없는 조회 타입입니다."),

    //Member
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER401", "사용자를 찾을 수 없습니다."),
    USER_IS_NOT_IN_TEAM(HttpStatus.NOT_FOUND, "MEMBER402", "유저가 속한 팀이 없습니다."),
    //FoodPrefer
    FOOD_PREFER_NOT_FOUND(HttpStatus.NOT_FOUND, "FOOD_PREFER401", "선호 음식을 찾을 수 없습니다."),

    //Team
    TEAM_NOT_FOUND(HttpStatus.NOT_FOUND, "TEAM401", "그룹을 찾을 수 없습니다."),

    //Food
    FOOD_NOT_FOUND(HttpStatus.NOT_FOUND, "FOOD401", "음식을 찾을 수 없습니다.");
    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}