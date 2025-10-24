package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String enterPlayerName(){
        String player = Console.readLine();
        return player;
    }

    public static void enterGameTurn(){
        String turn = Console.readLine();
        Console.close();
    }

}
