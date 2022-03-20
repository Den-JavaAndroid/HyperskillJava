package bullscows.validator;

public class UserInputValidator {
    public static boolean validateInputOfLengthCode(String input) {
        int l = 0;
        try {
            l = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.printf("Error: \"%s\" isn't a valid number.\n", input);
            return false;
        }
        if (l <= 0) {
            System.out.println("Error");
            return false;
        }
        return true;
    }

    public static boolean validateNumberOfPossibleSymbols(String input, String length) {
        boolean isValid = false;
        int numberPossibleSymbols = 0;
        try {
            numberPossibleSymbols = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.printf("Error: \"%s\" isn't a valid number.\n", input);
            return isValid;
        }
        int l = Integer.parseInt(length);
        if (numberPossibleSymbols - l < 0) {
            System.out.printf("Error: it's not possible to generate a code with a length of %s with %s unique symbols.\n", length, input);
            return isValid;
        }
        if (numberPossibleSymbols > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            return isValid;
        }
        return true;
    }
}
