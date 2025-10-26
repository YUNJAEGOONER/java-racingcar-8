package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    private final static String DASH = "-";

    public void printStartInfo(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
    }

    public void printSetTurnMessage(){
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printGameStatusInit(){
        System.out.print("\n실행 결과");
    }

    public void printGameStatus(List<Car> cars){
        cars.forEach(car -> System.out.printf("\n%s : %s", car.getName(), DASH.repeat(car.getDistance())));
        System.out.println();
    }

    public void printWinner(List<String> winnerList){
        String winners = String.join(", ", winnerList);
        System.out.printf("\n최종 우승자 : %s", winners);
    }

}
