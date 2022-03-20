package bullscows.generator;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    public static int generateRandomNumber(int length) throws GeneratorException {
        List<Integer> allNumbersList = getAllNumbersList();
        if (length > 10)
            throw new GeneratorException(String.format("Error: can't generate a secret number with a length of %s because there aren't enough unique digits.", length));
        boolean isPseudoRandomNumber = false;
        StringBuilder preudoRandomNumberBuilder = new StringBuilder();
        while (!isPseudoRandomNumber) {
            StringBuilder nanoTime = new StringBuilder(String.valueOf(System.nanoTime())).reverse();
            boolean isAllFrontZeroDeleted = false;
            for (int i = 0; i < nanoTime.length(); i++) {
                if (!isAllFrontZeroDeleted && nanoTime.charAt(i) == '0') {
                    nanoTime.deleteCharAt(i);
                    i--;
                } else {
                    isAllFrontZeroDeleted = true;
                    break;
                }
            }
            if (nanoTime.length() < 10) continue;

            for (int i = 0; i < nanoTime.length(); i++) {
                if (preudoRandomNumberBuilder.length() == length) {
                    isPseudoRandomNumber = true;
                    break;
                }
                int currentInt = Character.getNumericValue(nanoTime.charAt(i));
                if (allNumbersList.contains(currentInt)) {
                    preudoRandomNumberBuilder.append(currentInt);
                    allNumbersList.remove(new Integer(currentInt));
                }
            }
        }
        int randomNumber = Integer.parseInt(preudoRandomNumberBuilder.toString());
        System.out.println(String.format("The random secret number is %s.", randomNumber));
        return randomNumber;
    }

    private static List<Integer> getAllNumbersList() {
        List<Integer> allNumbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            allNumbers.add(i);
        }
        return allNumbers;
    }
}


