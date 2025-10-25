package racingcar.controller;

import java.util.List;
import racingcar.domain.Game;
import racingcar.parser.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final Game game;
    private final InputView inputView;
    private final OutputView outputView;
    private final InputParser inputParser;

    public GameController(InputView inputView, OutputView outputView, InputParser inputParser) {
        this.game = new Game();
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputParser = inputParser;
    }

    public void play(){
        initGame();
        playGame();
        endGame();
    }

    public void initGame(){
        outputView.printStartInfo();
        String [] players = setPlayers();
        game.initPlayer(players);
    }

    private String[] setPlayers(){
        String playerNames = inputView.enterPlayerName();
        return inputParser.parsePlayerName(playerNames);
    }

    private void playGame(){
        int turn = setTurn();
        outputView.printGameStatusInit();
        for(int i = 0 ; i < turn ; i ++ ) {
            game.playGame();
            outputView.printGameStatus(game.getCarList());
        }
    }

    private int setTurn(){
        outputView.printSetTurnMessage();
        String turnInput = inputView.enterGameTurn();
        return inputParser.parseTurnInput(turnInput);
    }

    private void endGame(){
        List<String> winners = game.rankPlayer();
        outputView.printWinner(winners);
    }

}
