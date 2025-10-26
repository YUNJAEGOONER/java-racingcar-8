package racingcar.parser;

import java.util.List;
import racingcar.exception.ExceptionCode;

public class InputParser {

    public String[] parsePlayerName(String input){
        String [] parsedInput = input.split(",");
        validatePlayerName(parsedInput);
        return parsedInput;
    }

    public int parseTurnInput(String input){
        validateNumber(input);
        try {
            return Integer.parseInt(input);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException(ExceptionCode.INPUT_TURN_ONLY_INTEGER);
        }
    }

    private void validatePlayerName(String[] parsedInput){
        for (String player : parsedInput) {
            if (player.isBlank() || player.length() >= 6) {
                throw new IllegalArgumentException(ExceptionCode.PLAYER_NAME_LENGTH_LIMIT);
            }
        }
        validateDuplicateName(parsedInput);
    }

    private void validateDuplicateName(String [] parsedInput){
        List<String> players = List.of(parsedInput);
        if(players.size() != players.stream().distinct().count()){
            throw new IllegalArgumentException(ExceptionCode.PLAYER_NAME_DUPLICATE);
        }
    }

    private static void validateNumber(String input){
        if(input.isBlank()){
            throw new IllegalArgumentException(ExceptionCode.INPUT_TURN_NOT_BLANK);
        }
        if(input.equals("0")){
            throw new IllegalArgumentException(ExceptionCode.INPUT_TURN_NUMBER_POSITIVE);
        }
        if(input.startsWith("0")){
            throw new IllegalArgumentException(ExceptionCode.INPUT_TURN_NUMBER_FORMAT);
        }
        if ((!input.matches("^[0-9]+$"))){
            throw new IllegalArgumentException(ExceptionCode.INPUT_TURN_ONLY_NUMBER);
        }
    }

}
