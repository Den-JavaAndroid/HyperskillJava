package bullscows.validator;


import bullscows.GuessTypes;

import java.util.HashMap;
import java.util.Map;

import static bullscows.GuessTypes.*;

public class CodeGrader {
    private final String GUESS = "1234";
    private Map<GuessTypes, Integer> gradeResult;

    public Map<GuessTypes, Integer> analyzeNumber(int number) {
        gradeResult = new HashMap<>();
        gradeResult.put(BULLS, 0);
        gradeResult.put(COWS, 0);
        var convertedNumber = String.valueOf(number);
        for (int i = 0; i < GUESS.length(); i++) {
            if (convertedNumber.charAt(i) == GUESS.charAt(i)) {
                gradeResult.put(BULLS, gradeResult.get(BULLS) + 1);
            } else if (GUESS.contains(convertedNumber.charAt(i) + "")) {
                gradeResult.put(COWS, gradeResult.get(COWS) + 1);
            }
        }
        return gradeResult;
    }

    public String getGradeResultsMessage() {
        String message = "";
        if (gradeResult.get(BULLS) > 0 && gradeResult.get(COWS) >= 0) {
            message = String.format("Grade: %s bull(s) and %s cow(s). The secret code is %s.", gradeResult.get(BULLS), gradeResult.get(COWS), GUESS);
        } else {
            if (gradeResult.get(BULLS) == 0 && gradeResult.get(COWS) > 0) {
                message = String.format("Grade: %s cow(s). The secret code is %s.", gradeResult.get(COWS), GUESS);
            } else {
                message = String.format("Grade: None. The secret code is %s.", GUESS);
            }
        }
        return message;
    }
}
