package bullscows.validator;


import bullscows.GuessTypes;

import java.util.HashMap;
import java.util.Map;

import static bullscows.GuessTypes.*;

public class CodeGrader {
    private String guess;
    private Map<GuessTypes, Integer> gradeResult;

    public CodeGrader(String guess) {
        this.guess = String.valueOf(guess);
    }

    public Map<GuessTypes, Integer> analyzeNumber(String number) {
        gradeResult = new HashMap<>();
        gradeResult.put(BULLS, 0);
        gradeResult.put(COWS, 0);
        for (int i = 0; i < guess.length(); i++) {
            if (number.charAt(i) == guess.charAt(i)) {
                gradeResult.put(BULLS, gradeResult.get(BULLS) + 1);
            } else if (guess.contains(number.charAt(i) + "")) {
                gradeResult.put(COWS, gradeResult.get(COWS) + 1);
            }
        }
        return gradeResult;
    }

    public String getGradeResultsMessage() {
        String message = "";
        if (guess.length() == gradeResult.get(BULLS)) {
            return String.format("Grade: %s bulls\n" +
                    "Congratulations! You guessed the secret code.", guess.length());
        }
        if (gradeResult.get(BULLS) > 0 && gradeResult.get(COWS) > 0) {
            message = String.format("Grade: %s bull(s) and %s cow(s).", gradeResult.get(BULLS), gradeResult.get(COWS));
        } else {
            if (gradeResult.get(BULLS) == 0 && gradeResult.get(COWS) > 0) {
                message = String.format("Grade: %s cow(s).", gradeResult.get(COWS));
            } else {
                message = "Grade: None";
            }
        }
        return message;
    }
}
