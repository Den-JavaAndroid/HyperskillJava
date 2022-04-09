package battleship.view;

import battleship.ShipType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class BattleField {
    private final char FOG_OF_WAR_CELL = '~';
    private final char YOUR_SHIP_CELL = 'O';
    private final char HIT_SHIP_CELL = 'X';
    private final char MISS_SHOT_CELL = 'M';
    private char[] rowSymbols = "ABCDEFGHIJ".toCharArray();
    private HashMap<String, Character> field;
    private Scanner scanner = new Scanner(System.in);

    public BattleField() {
        field = getEmptyField();
    }


    public HashMap<String, Character> placeShip(ShipType shipType) {
        System.out.println(String.format("Enter the coordinates of the %s (%s cells):", shipType.getName(), shipType.getLength()));
        String coordinateStart;
        String coordinateEnd;
        boolean isCorrectLength = false;
        while (!isCorrectLength) {
            coordinateStart = scanner.next();
            coordinateEnd = scanner.next();
            if (getSheepLength(coordinateStart, coordinateEnd) == shipType.getLength()) {
                if (!checkCoordinates(coordinateStart, coordinateEnd)) continue;
                placeSheep(coordinateStart, coordinateEnd);
                isCorrectLength = true;
            } else {
                System.out.println(String.format("Error! Wrong length of the %s! Try again:", shipType.getName()));
            }
        }
        printField();
        return field;
    }

    public HashMap<String, Character> placeBattleship() {
        System.out.println("Enter the coordinates of the Battleship (4 cells):");
        String coordinateStart;
        String coordinateEnd;
        boolean isCorrectLength = false;
        while (!isCorrectLength) {
            coordinateStart = scanner.next();
            coordinateEnd = scanner.next();
            if (getSheepLength(coordinateStart, coordinateEnd) == 4) {
                if (!checkCoordinates(coordinateStart, coordinateEnd)) continue;
                placeSheep(coordinateStart, coordinateEnd);
                isCorrectLength = true;
            } else {
                System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
            }
        }
        printField();
        return field;
    }

    public HashMap<String, Character> placeSubmarine() {
        System.out.println("Enter the coordinates of the Submarine (3 cells):");
        String coordinateStart;
        String coordinateEnd;
        boolean isCorrectLength = false;
        while (!isCorrectLength) {
            coordinateStart = scanner.next();
            coordinateEnd = scanner.next();
            if (getSheepLength(coordinateStart, coordinateEnd) == 3) {
                if (!checkCoordinates(coordinateStart, coordinateEnd)) continue;
                placeSheep(coordinateStart, coordinateEnd);
                isCorrectLength = true;
            } else {
                System.out.println("Error! Wrong length of the Submarine! Try again:");
            }
        }
        printField();
        return field;
    }

    public HashMap<String, Character> placeCruiser() {
        System.out.println("Enter the coordinates of the Cruiser (3 cells):");
        String coordinateStart;
        String coordinateEnd;
        boolean isCorrectLength = false;
        while (!isCorrectLength) {
            coordinateStart = scanner.next();
            coordinateEnd = scanner.next();
            if (getSheepLength(coordinateStart, coordinateEnd) == 3) {
                if (!checkCoordinates(coordinateStart, coordinateEnd)) continue;
                placeSheep(coordinateStart, coordinateEnd);
                isCorrectLength = true;
            } else {
                System.out.println("Error! Wrong length of the Cruiser! Try again:");
            }
        }
        printField();
        return field;
    }

    public HashMap<String, Character> placeDestroyer() {
        System.out.println("Enter the coordinates of the Destroyer (2 cells):");
        String coordinateStart;
        String coordinateEnd;
        boolean isCorrectLength = false;
        while (!isCorrectLength) {
            coordinateStart = scanner.next();
            coordinateEnd = scanner.next();
            if (getSheepLength(coordinateStart, coordinateEnd) == 2) {
                if (!checkCoordinates(coordinateStart, coordinateEnd)) continue;
                placeSheep(coordinateStart, coordinateEnd);
                isCorrectLength = true;
            } else {
                System.out.println("Error! Wrong length of the Destroyer! Try again:");
            }
        }
        printField();
        return field;
    }

    private boolean checkCoordinates(String startCoordinate, String endCoordinate) {
        char symbolStart = startCoordinate.split("\\d")[0].charAt(0);
        int numberStart = Integer.parseInt(startCoordinate.split("\\D")[1]);
        char symbolEnd = endCoordinate.split("\\d")[0].charAt(0);
        int numberEnd = Integer.parseInt(endCoordinate.split("\\D")[1]);
        if (symbolStart != symbolEnd) {
            if (numberStart != numberEnd) {
                System.out.println("Error! Wrong ship location! Try again:");
                return false;
            }
        }
        return true;
    }


    private int getSheepLength(String startCoordinate, String endCoordinate) {
        char symbolStart = startCoordinate.split("\\d")[0].charAt(0);
        int numberStart = Integer.parseInt(startCoordinate.split("\\D")[1]);
        char symbolEnd = endCoordinate.split("\\d")[0].charAt(0);
        int numberEnd = Integer.parseInt(endCoordinate.split("\\D")[1]);
        if (symbolStart == symbolEnd) {
            if (numberEnd > numberStart)
                return Math.abs(numberEnd - numberStart + 1);
            else
                return Math.abs(numberEnd - numberStart - 1);
        } else {
            if (symbolStart < symbolEnd)
                return Math.abs(symbolStart - symbolEnd - 1);
            else return Math.abs(symbolEnd - symbolStart + 1);
        }
    }

    public HashMap<String, Character> placeSheep(String startCoordinate, String endCoordinate) {
        char symbolStart = startCoordinate.split("\\d")[0].charAt(0);
        int numberStart = Integer.parseInt(startCoordinate.split("\\D")[1]);
        char symbolEnd = endCoordinate.split("\\d")[0].charAt(0);
        int numberEnd = Integer.parseInt(endCoordinate.split("\\D")[1]);
        if (symbolStart == symbolEnd) {
            int startNumber = numberStart;
            int endNumber = numberEnd;
            if (startNumber > endNumber) {
                startNumber = numberEnd;
                endNumber = numberStart;
            }

            for (int i = startNumber; i <= endNumber; i++) {
                field.put(String.format("%s%s", symbolStart, i), YOUR_SHIP_CELL);
            }
        } else {
            char startSymbol = symbolStart;
            char endSymbol = symbolEnd;
            if (symbolStart > symbolEnd) {
                startSymbol = symbolEnd;
                endSymbol = symbolStart;
            }
            for (int i = startSymbol; i <= endSymbol; i++) {
                field.put(String.format("%s%s", (char) i, numberStart), YOUR_SHIP_CELL);
            }

            System.out.println();
        }


        return field;
    }

    public HashMap<String, Character> getEmptyField() {
        HashMap<String, Character> field = new HashMap<>();
        for (int i = 1; i <= rowSymbols.length; i++) {
            for (int j = 1; j <= 10; j++) {
                field.put(String.format("%s%s", rowSymbols[i - 1], j), FOG_OF_WAR_CELL);
            }
        }
        return field;
    }

    public void printField() {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for (int i = 1; i <= rowSymbols.length; i++) {
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(rowSymbols[i - 1])).append(" ");
            for (int j = 1; j <= 10; j++) {
                stringBuilder.append(field.get(rowSymbols[i - 1] + String.valueOf(j))).append(" ");
            }
            System.out.println(stringBuilder);
        }
    }

    public void takeShot() {
        System.out.println("Take a shot!");
        boolean isCorrectCoordinate = false;
        while (!isCorrectCoordinate) {
            String coordinate = scanner.next();
            char symbol = coordinate.split("\\d")[0].charAt(0);
            int number = Integer.parseInt(coordinate.split("\\D")[1]);
            if (!Arrays.toString(rowSymbols).contains(symbol + "") || number > 10 || number < 1) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
                continue;
            }
            if (field.get(coordinate).equals(YOUR_SHIP_CELL)) {
                field.put(coordinate, HIT_SHIP_CELL);
                printField();
                System.out.println("You hit a ship!");
            } else {
                field.put(coordinate, MISS_SHOT_CELL);
                printField();
                System.out.println("You missed!");
            }

            isCorrectCoordinate = true;

        }
    }
}
