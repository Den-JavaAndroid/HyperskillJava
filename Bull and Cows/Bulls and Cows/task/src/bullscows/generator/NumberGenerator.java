package bullscows.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {

    public static String generateRandomNumber(String lengthStr, String numberOfPossibleSymbolsStr) throws GeneratorException {
        List<Integer> allNumbersList = getAllNumbersList();
        int length = Integer.parseInt(lengthStr);
        int numberOfPossibleSymbols = Integer.parseInt(numberOfPossibleSymbolsStr);
        if (length > 10)
            throw new GeneratorException(String.format("Error: can't generate a secret number with a length of %s because there aren't enough unique digits.", length));
        int numberLetters = numberOfPossibleSymbols > 10 ? numberOfPossibleSymbols - 10 : 0;
        ArrayList<Character> englishSymbols = getEnglishSymbols(numberLetters);
        ArrayList<Character> usedEnglishSymbols = new ArrayList<>(englishSymbols);

        Random random = new Random();
        StringBuilder randomNumberBuilder = new StringBuilder();
        var isRandomCoderBuilded = false;
        while (!isRandomCoderBuilded) {
            int randomInt = random.nextInt(10);
            if (numberLetters > 0) {
                int randomSymbolNumber = random.nextInt(numberLetters-1);
                Character randomCharacter = usedEnglishSymbols.get(randomSymbolNumber);
                if (englishSymbols.contains(randomCharacter)) {
                    randomNumberBuilder.append(randomCharacter);
                    englishSymbols.remove(randomCharacter);
                    if (randomNumberBuilder.length() == length) {
                        isRandomCoderBuilded = true;
                        continue;
                    }
                }
            }
            if (allNumbersList.contains(randomInt)) {
                randomNumberBuilder.append(randomInt);
                allNumbersList.remove(new Integer(randomInt));
            }
            if (randomNumberBuilder.length() == length) {
                isRandomCoderBuilded = true;
            }
        }
        String secreteCode = randomNumberBuilder.toString();
        if (numberLetters > 0)
            System.out.printf("The secret is prepared: %s (0-9, a-%s).\n", secreteCode.replaceAll("[a-z0-9]", "*"), usedEnglishSymbols.get(numberLetters-1));
        else
            System.out.printf("The secret is prepared: %s (0-9).\n", secreteCode.replaceAll("[0-9]", "*"));
        return secreteCode;
    }

    private static List<Integer> getAllNumbersList() {
        List<Integer> allNumbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            allNumbers.add(i);
        }
        return allNumbers;
    }

    private static ArrayList<Character> getEnglishSymbols(int countSymbols) {
        String allEnglishSymbols = "A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z".replaceAll(", ", "").toLowerCase();
        var symbols = new ArrayList<Character>();
        for (int i = 0; i < countSymbols; i++) {
            symbols.add(allEnglishSymbols.charAt(i));
        }
        return symbols;
    }
}


