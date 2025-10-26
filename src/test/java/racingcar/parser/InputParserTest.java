package racingcar.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ExceptionCode;

class InputParserTest {

    private InputParser inputParser;

    @BeforeEach
    void setUp(){
        inputParser = new InputParser();
    }

    @Test
    @DisplayName("이름이 6글자가 넘어가는 경우에는 예외 발생 - 검증 실패")
    void parsePlayerNameLengthFail() {
        //given
        String input = "ian,james,gabriel";

        //when - then
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> inputParser.parsePlayerName(input)
        );

        assertThat(e.getMessage()).isEqualTo(ExceptionCode.PLAYER_NAME_LENGTH_LIMIT);
    }

    @Test
    @DisplayName("이름으로 공백을 허용하지 않음")
    void parsePlayerNameBlankFail() {
        //given
        String input = ",james,gabi";

        //when - then
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> inputParser.parsePlayerName(input)
        );

        assertThat(e.getMessage()).isEqualTo(ExceptionCode.PLAYER_NAME_LENGTH_LIMIT);
    }

    @Test
    @DisplayName("입력을 검증하고 구분자(,)를 기준으로 파싱")
    void parsePlayerName() {
        //given
        String input = "alex,james,gabi";

        //when
        String[] players = inputParser.parsePlayerName(input);

        //then
        assertAll(
                () -> assertThat(players.length).isEqualTo(3),
                () -> assertThat(List.of(players).contains("alex")).isEqualTo(true)
        );
    }

    @Test
    @DisplayName("숫자 이외의 문자를 포함하고 있는 경우에는 예외가 발생")
    void parseTurnInputFail() {
        //given
        String input = "3.5";

        //when - then
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> inputParser.parseTurnInput(input)
        );

        assertThat(e.getMessage()).isEqualTo(ExceptionCode.INPUT_TURN_ONLY_NUMBER);
    }


    @Test
    @DisplayName("숫자 이외의 문자를 포함하고 있는 경우에는 예외가 발생")
    void parseTurnInputNotStartWithZero() {
        //given
        String input = "05123";

        //when - then
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> inputParser.parseTurnInput(input)
        );

        assertThat(e.getMessage()).isEqualTo(ExceptionCode.INPUT_TURN_NUMBER_FORMAT);
    }


    @Test
    @DisplayName("턴 횟수가 정수보타 큰 경우 오버플로우 발생")
    void parseTurnInputOverflow() {
        //given
        String input = "2147483648";

        //when - then
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> inputParser.parseTurnInput(input)
        );

        assertThat(e.getMessage()).isEqualTo(ExceptionCode.INPUT_TURN_ONLY_INTEGER);
    }

}