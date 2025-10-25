package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car>{

    private String name;

    private int distance = 0;

    private static final int threshold = 4;

    public Car(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void drive(){
        if (Randoms.pickNumberInRange(0, 9) >= threshold){
            this.distance ++;
        }
    }

    @Override
    public int compareTo(Car car) {
        return car.distance - this.distance;
    }
}
