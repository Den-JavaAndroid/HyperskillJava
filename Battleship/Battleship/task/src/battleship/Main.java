package battleship;

import battleship.view.BattleField;

public class Main {

    public static void main(String[] args) {

        BattleField battleField = new BattleField();
        battleField.printField();
        battleField.placeAirCraftCarrier();
        battleField.placeBattleship();
        battleField.placeSubmarine();
        battleField.placeCruiser();
        battleField.placeDestroyer();

    }
}
