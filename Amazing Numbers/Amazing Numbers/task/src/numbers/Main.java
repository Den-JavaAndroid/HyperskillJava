package numbers;

import java.util.Scanner;


public class Main {
    private static final String EXIT_SYMBOL = "0";

    public static void main(String... __) {
        printWelcome();
        printInstructions();
        String input = getUserInput();

        while (!input.equals(EXIT_SYMBOL)) {
            AmazingNumberController amazingNumberController = new AmazingNumberController(input);
            input = getUserInput();
        }
        System.out.println("\nGoodbye!");
    }

    private static void printWelcome() {
        System.out.println("Welcome to Amazing Numbers!");
    }

    private static void printInstructions() {
        System.out.println("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be processed;\n" +
                "- two natural numbers and properties to search for;\n" +
                "- a property preceded by minus must not be present in numbers;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");;
    }

    private static String getUserInput() {
        System.out.print("\nEnter a request: > ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
