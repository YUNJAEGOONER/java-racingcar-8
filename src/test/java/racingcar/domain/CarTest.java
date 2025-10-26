package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ExceptionCode;

class CarTest {

    @Test
    @DisplayName("drive메서드 수행 시, distance가 1 증가")
    void drive() {
        //given
        Car car = new Car("Mac");

        //when
        car.drive();

        //then
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("이름이 6글자 이상인 경우에는 예외가 발생")
    void validatePlayerName() {
        //given
        String name = "TimCook";

        //when-then
        IllegalArgumentException e =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> new Car(name)
                );
        assertThat(e.getMessage()).isEqualTo(ExceptionCode.PLAYER_NAME_LENGTH_LIMIT);
    }
}