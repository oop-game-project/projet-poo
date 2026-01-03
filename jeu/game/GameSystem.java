package game;

import map.GameMap;
import map.Position;
import game.units.Unit;
import game.units.Solider;
import game.units.Archer;
import game.units.Tank;
import game.units.Magicien;
import game.units.Cavalier;
import game.buildings.Building;
import game.player.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameSystem {

    private GameMap map;
    private Player player;
    private Position playerPos;
    private List<Unit> units;
    private List<Building> buildings;
    private Scanner sc;

    public GameSystem(int mapWidth, int mapHeight, Player player) {
        this.map = new GameMap(mapWidth, mapHeight);
        this.player = player;
        this.playerPos = new Position(0, 0);
        this.units = new ArrayList<>();
        this.buildings = new ArrayList<>();
        this.sc = new Scanner(System.in);
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public void addBuilding(Building building) {
        buildings.add(building);
    }

    private void showUnits() {
        System.out.println("\n=== UNITÉS ===");
        for (Unit u : units) {
            u.affichage();
            System.out.println("Position: (" + u.getPositionX() + "," + u.getPositionY() + ")");
        }
    }

    public void run() {
        boolean running = true;

        while (running) {
            System.out.println("\n=== MAP ===");
            map.printWithPlayer(playerPos);

            System.out.println("Position du joueur: (" + playerPos.x + "," + playerPos.y + ")");
            System.out.println("Defense bonus: " + map.getDefenseBonusAt(playerPos.x, playerPos.y));
            player.showResources();

            System.out.println("\nCommandes: w/a/s/d = déplacement, u = utiliser bâtiment, q = quitter");
            String cmd = sc.nextLine().trim().toLowerCase();
            if (cmd.isEmpty()) {
                continue;
            }

            char c = cmd.charAt(0);

            switch (c) {
                case 'w' ->
                    movePlayer(0, -1);
                case 's' ->
                    movePlayer(0, 1);
                case 'a' ->
                    movePlayer(-1, 0);
                case 'd' ->
                    movePlayer(1, 0);
                case 'u' ->
                    useBuilding();
                case 'q' ->
                    running = false;
                default ->
                    System.out.println("Commande inconnue !");
            }

            showUnits();

            if (isGameOver()) {
                System.out.println("🏆 Fin du jeu !");
                running = false;
            }
        }

        System.out.println("Merci d’avoir joué !");
    }

    private void movePlayer(int dx, int dy) {
        if (map.move(playerPos, dx, dy)) {
            System.out.println("Déplacement réussi !");
        } else {
            System.out.println("Déplacement impossible !");
        }
    }

    private void useBuilding() {
        System.out.println("\n=== BÂTIMENTS ===");
        for (int i = 0; i < buildings.size(); i++) {
            System.out.println(i + ": " + buildings.get(i).getName());
        }
        System.out.print("Choisir bâtiment à utiliser: ");
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice >= 0 && choice < buildings.size()) {
            buildings.get(choice).use();
        } else {
            System.out.println("Bâtiment inexistant !");
        }
    }

    private boolean isGameOver() {
        int alive = 0;
        for (Unit u : units) {
            if (u.isAlive()) {
                alive++;
            }
        }
        return alive <= 1;
    }
}
