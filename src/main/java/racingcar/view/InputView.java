package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String enterPlayerName(){
        return Console.readLine();
    }

    public static String enterGameTurn(){
        String turn = Console.readLine();
        Console.close();
        return turn;
    }


}
