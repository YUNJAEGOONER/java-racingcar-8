package racingcar.domain;

import static racingcar.view.OutputView.printGameStatus;
import static racingcar.view.OutputView.printGameStatusInit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    private final List<Car> carList = new ArrayList<>();

    public void initPlayer(String[] playerNames){
        for (String playerName : playerNames) {
            carList.add(new Car(playerName));
        }
    }

    public void playGame(int turn){
        printGameStatusInit();
        for(int i = 0 ; i < turn ; i ++ ){
            for (Car car : carList) {
                car.drive();
            }
            printGameStatus(carList);
        }
    }

    public List<String> rankPlayer(){
        Collections.sort(carList);
        int maxDistance = carList.get(0).getDistance();
        return carList.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(car -> car.getName())
                .toList();
    }

}
