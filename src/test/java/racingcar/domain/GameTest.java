package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    private Game game;

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @BeforeEach
    void setUp(){
        game = new Game();
    }

    @Test
    @DisplayName("입력 받은 플레이어의 이름을 바탕으로 game 도메인의 carList 초기화")
    void initPlayer() {
        //given
        String [] playerName = {"ian", "jason", "java"};

        //when
        game.initPlayer(playerName);

        //then
        assertAll(
                () -> assertThat(game.getCarList().size()).isEqualTo(3),
                () -> assertThat(game.getCarList().stream().anyMatch(car -> car.getName().contains("ian"))).isEqualTo(true)
        );
    }

    @Test
    @DisplayName("반환된 랜덤 값을 기준으로 ")
    void playGame() {
        //given - when
        String [] playerName = {"ian", "jason"};
        game.initPlayer(playerName);

        assertRandomNumberInRangeTest(
                () -> {
                    game.playGame();
                    //then
                    List<Car> result = game.getCarList();
                    assertAll(
                            () -> assertThat(result.get(0).getName()).isEqualTo("ian"),
                            () -> assertThat(result.get(0).getDistance()).isEqualTo(1),
                            () -> assertThat(result.get(1).getName()).isEqualTo("jason"),
                            () -> assertThat(result.get(1).getDistance()).isEqualTo(0)
                    );
                },
                MOVING_FORWARD,
                STOP
        );
    }

    @Test
    @DisplayName("플레이어의 순위 매기기 - 단독 우승에서 우승자 가져오기")
    void rankPlayer() {
        //given
        game.initPlayer(new String[]{"jason", "ian"});

        List<Car> carList = game.getCarList();
        Car car1 = carList.get(0);
        for(int i  = 0 ; i < 5 ; i ++ ){
            car1.drive();
        }

        Car car2 = carList.get(1);
        for(int i  = 0 ; i < 10 ; i ++ ){
            car2.drive();
        }

        //when
        List<String> players = game.rankPlayer();

        //then
        assertAll(
                () -> assertThat(players.size()).isEqualTo(1),
                () -> assertThat(players.get(0)).isEqualTo("ian")
        );
    }

    @Test
    @DisplayName("플레이어의 순위 매기기 - 공동 우승자가 존재하는 경우")
    void rankPlayerMultipleWinner() {
        //given
        game.initPlayer(new String[]{"jason", "ian"});

        List<Car> carList = game.getCarList();
        Car car1 = carList.get(0);
        for(int i  = 0 ; i < 10 ; i ++ ){
            car1.drive();
        }

        Car car2 = carList.get(1);
        for(int i  = 0 ; i < 10 ; i ++ ){
            car2.drive();
        }

        //when
        List<String> players = game.rankPlayer();

        //then
        assertAll(
                () -> assertThat(players.size()).isEqualTo(2),
                () -> assertThat(players.stream().anyMatch(p -> p.contains("jason"))).isEqualTo(true)
        );
    }

}