package bullscows;

import bullscows.generator.GeneratorException;
import bullscows.generator.NumberGenerator;
import bullscows.validator.CodeGrader;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CodeGrader codeGrader = new CodeGrader();
        int userInput = scanner.nextInt();
        try {
            NumberGenerator.generateRandomNumber(userInput);
        } catch (GeneratorException e) {
            System.out.println(e.getMessage());
        }
//        codeGrader.analyzeNumber(userInput);
//        System.out.println(codeGrader.getGradeResultsMessage());
    }

}
