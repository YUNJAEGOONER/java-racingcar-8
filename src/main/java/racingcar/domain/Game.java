package racingcar.domain;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    private final List<Car> carList = new ArrayList<>();
    private static final int threshold = 4;

    public void initPlayer(String[] playerNames){
        for (String playerName : playerNames) {
            carList.add(new Car(playerName));
        }
    }

    public void playGame(){
        for (Car car : carList) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if(randomNum >= threshold){
                car.drive();
            }
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

    public List<Car> getCarList() {
        return carList;
    }
}
