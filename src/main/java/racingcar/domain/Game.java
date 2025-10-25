package racingcar.domain;

import static racingcar.view.OutputView.printGameStatus;
import static racingcar.view.OutputView.printGameStatusInit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    private List<Car> carList = new ArrayList<>();

    public void initPlayer(String[] playerNames){
        for(int i = 0 ; i < playerNames.length ; i ++ ){
            carList.add(new Car(playerNames[i]));
        }
    }

    public void playGame(int turn){
        printGameStatusInit();
        for(int i = 0 ; i < turn ; i ++ ){
            for(int j = 0 ; j <  carList.size() ; j ++ ){
                carList.get(j).drive();
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
