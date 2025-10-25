package racingcar.controller;

import static racingcar.view.InputView.*;
import static racingcar.view.OutputView.*;

import java.util.List;
import racingcar.domain.Game;
import racingcar.parser.InputParser;

public class GameController {

    private Game game;

    public void play(){
        initGame();
        playGame();
        endGame();
    }

    public void initGame(){
        printStartInfo();
        String [] players = setPlayers();
        Game game = new Game();
        game.initPlayer(players);
        this.game = game;
    }

    private String[] setPlayers(){
        String playerNames = enterPlayerName();
        return InputParser.parsePlayerName(playerNames);
    }

    private void playGame(){
        int turn = setTurn();
        game.playGame(turn);
    }

    private int setTurn(){
        printSetTurnMessage();
        String turnInput = enterGameTurn();
        return InputParser.parseTurnInput(turnInput);
    }

    private void endGame(){
        List<String> winners = game.rankPlayer();
        printWinner(winners);
    }

}
