package battleship;

import battleship.view.BattleField;

public class Main {

    public static void main(String[] args) {

        BattleField battleField = new BattleField();
        battleField.printField();
        battleField.placeShip(ShipType.AIRCRAFT_CARRIER);
        battleField.placeShip(ShipType.BATTLESHIP);
        battleField.placeShip(ShipType.SUBMARINE);
        battleField.placeShip(ShipType.CRUISER);
        battleField.placeShip(ShipType.DESTROYER);
        System.out.println("The game starts!");
        battleField.printField();
        battleField.takeShot();

    }
}
