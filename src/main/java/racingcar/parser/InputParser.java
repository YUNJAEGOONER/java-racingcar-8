package racingcar.parser;

import java.util.List;

public class InputParser {

    public static String[] parsePlayerName(String input){
        String [] parsedInput = input.split(",");
        validatePlayerName(parsedInput);
        return parsedInput;
    }

    public static int parseTurnInput(String input){
        validateNumber(input);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형태를 입력해주세요");
        }
    }

    private static void validatePlayerName(String[] parsedInput){
        for (String player : parsedInput) {
            if (player.isBlank() || player.length() >= 6) {
                throw new IllegalArgumentException("플레이어의 이름은 1글자 이상 5글자 이하이어여 합니다.");
            }
        }
        validateDuplicateName(parsedInput);
    }

    private static void validateDuplicateName(String [] parsedInput){
        List<String> players = List.of(parsedInput);
        if(players.size() != players.stream().distinct().count()){
            throw new IllegalArgumentException("플레이어의 이름은 중복될 수 없습니다.");
        }
    }

    private static void validateNumber(String input){
        if(input.startsWith("0") || (!input.matches("^[0-9]+$"))){
            throw new IllegalArgumentException("0으로 시작하지 않는 양의 정수를 입력해 주세요");
        }
    }

}
