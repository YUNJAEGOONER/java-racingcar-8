package racingcar.View;

import java.util.List;
import org.junit.platform.commons.util.StringUtils;
import racingcar.domain.Car;

public class OutputView {

    public final static String dStr = "-";

    public static void printStartInfo(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
    }

    public static void printSetTurnMessage(){
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void printGameStatusInit(){
        System.out.println("실행 결과");
    }

    public static void printGameStatus(List<Car> cars){
        cars.forEach(car -> System.out.printf("%s : %s", car.getName(), dStr.repeat(car.getDistance())));
    }

    public static void printWinner(List<String> winnerList){
        String winners = String.join(",", winnerList);
        System.out.printf("최종 우승자 : %s", winners);
    }





}
