package battleship.view;

public class Coordinate {
    private int number;
    private char symbol;
    private char value;

    private final char FOG_OF_WAR_CELL = '~';
    private final char YOUR_SHIP_CELL = 'O';
    private final char HIT_SHIP_CELL = 'X';
    private final char MISS_SHOT_CELL = 'M';

    public Coordinate(int number, char symbol) {
        this.number = number;
        this.symbol = symbol;
        this.value = FOG_OF_WAR_CELL;
    }
}
