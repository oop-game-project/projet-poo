package game;

import game.buildings.*;
import game.player.Player;
import game.units.*;

public class GameLauncher {
 
    public static void main(String[] args) {

        Player player = new Player("Player 1");
        GameSystem game = new GameSystem(6, 6, player);

        game.addUnit(new Solider(0, 0));
        game.addUnit(new Archer(1, 1));
        game.addUnit(new Tank(2, 2));
        game.addUnit(new Magicien(3, 3));
        game.addUnit(new Cavalier(4, 4));

        game.addBuilding(new CommandCenter());
        game.addBuilding(new Farm());
        game.addBuilding(new Sawmill());
        game.addBuilding(new Mine());
        game.addBuilding(new TrainingCamp());

        game.run();
    }
}
