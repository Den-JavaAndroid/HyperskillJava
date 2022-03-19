package bullscows;

import bullscows.validator.CodeGrader;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CodeGrader codeGrader = new CodeGrader();
        int userInput = scanner.nextInt();
        codeGrader.analyzeNumber(userInput);
        System.out.println(codeGrader.getGradeResultsMessage());
    }

}
