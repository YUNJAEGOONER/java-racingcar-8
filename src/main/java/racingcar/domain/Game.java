package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.util.RandomNumberGenerator;

public class Game {

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private final List<Car> carList = new ArrayList<>();
    private static final int threshold = 4;

    public void initPlayer(String[] playerNames){
        for (String playerName : playerNames) {
            carList.add(new Car(playerName));
        }
    }

    public void playGame(){
        for (Car car : carList) {
            int randomNum = randomNumberGenerator.generateRandomNumber();
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
