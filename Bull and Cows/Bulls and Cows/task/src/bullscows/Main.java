package bullscows;

import bullscows.generator.GeneratorException;
import bullscows.generator.NumberGenerator;
import bullscows.validator.CodeGrader;
import bullscows.validator.UserInputValidator;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String guess = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the length of the secret code:");
        String lenghtOfSecretCode = scanner.next();
        if (!UserInputValidator.validateInputOfLengthCode(lenghtOfSecretCode)) {
            return;
        }
        System.out.println("Input the number of possible symbols in the code:");
        String numberOfPossibleSymbols = scanner.next();
        if (!UserInputValidator.validateNumberOfPossibleSymbols(numberOfPossibleSymbols, lenghtOfSecretCode)) {
            return;
        }
        try {
            guess = NumberGenerator.generateRandomNumber(lenghtOfSecretCode, numberOfPossibleSymbols);
        } catch (GeneratorException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Okay, let's start a game!");

        CodeGrader codeGrader = new CodeGrader(guess);

        var isGameOver = false;
        var turnNumber = 0;
        while (!isGameOver) {
            System.out.printf("Turn %d:", ++turnNumber);
            var number = scanner.next();
            Map<GuessTypes, Integer> turnResult = codeGrader.analyzeNumber(number);
            System.out.println(codeGrader.getGradeResultsMessage());
            if (Objects.equals(number, guess)) isGameOver = true;
        }
    }

}
