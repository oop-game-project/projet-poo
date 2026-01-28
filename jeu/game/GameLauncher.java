package game;

import player.Player;
import units.*;

import java.util.Scanner;

public class GameLauncher {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Choisissez votre personnage ===");
        System.out.println("Options : Soldier | Archer | Tank | Magicien | Cavalier");
        String choix = sc.nextLine().trim().toLowerCase();

        Unit playerUnit;

        switch (choix) {
            case "archer" -> playerUnit = new Archer(0, 0);
            case "tank" -> playerUnit = new Tank(0, 0);
            case "magicien" -> playerUnit = new Magicien(0, 0);
            case "cavalier" -> playerUnit = new Cavalier(0, 0);
            default -> playerUnit = new Soldier(0, 0);
        }

        Player player = new Player("Joueur");

        GameSystem game = new GameSystem(6, 6, player, playerUnit);

        game.addEnemy(new Soldier(1, 1));
        game.addEnemy(new Archer(2, 2));
        game.addEnemy(new Tank(3, 3));
        game.addEnemy(new Magicien(4, 1));
        game.addEnemy(new Cavalier(1, 4));

        game.run();

        sc.close();
    }
}
