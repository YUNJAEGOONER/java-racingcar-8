package racingcar.exception;

public class ExceptionCode {
  public static final String PLAYER_NAME_DUPLICATE = "플레이어의 이름은 중복될 수 없습니다.";
  public static final String PLAYER_NAME_LENGTH_LIMIT = "플레이어의 이름은 1글자 이상 5글자 이하이어야 합니다.";

  public static final String INPUT_TURN_NOT_BLANK = "게임을 플레이할 횟수를 입력해 주세요(공백은 허용되지 않습니다.)";
  public static final String INPUT_TURN_NUMBER_FORMAT = "양의 정수는 0으로 시작할 수 없습니다.";
  public static final String INPUT_TURN_NUMBER_POSITIVE = "0보다 큰 양의 정수를 입력해주세요";
  public static final String INPUT_TURN_ONLY_NUMBER = "숫자만 입력해 주세요 (특수 기호는 포함 되지 않습니다.)";
  public static final String INPUT_TURN_ONLY_INTEGER = "정수 범위 이내에서 입력해주세요(0 ~ 2147483647)";
}

