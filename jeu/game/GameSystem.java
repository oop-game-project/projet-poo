package game;

import map.GameMap;
import map.Position;
import units.Unit;
import player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameSystem {

    private final GameMap map;
    private final Player player;
    private final Unit playerUnit;
    private final Position playerPos;

    private final List<Unit> enemyUnits = new ArrayList<>();
    private final Random random = new Random();
    private final Scanner sc = new Scanner(System.in);

    private boolean running = true;

    public GameSystem(int width, int height, Player player, Unit playerUnit) {
        this.map = new GameMap(width, height, true); 
        this.player = player;
        this.playerUnit = playerUnit;
        this.playerPos = new Position(0, 0);
        playerUnit.move(0, 0);
    }


    public void addEnemy(Unit u) {
        placeEnemyRandomly(u);
        enemyUnits.add(u);
    }

    private void placeEnemyRandomly(Unit u) {
        int x, y;
        do {
            x = random.nextInt(map.getWidth());
            y = random.nextInt(map.getHeight());
        } while (!map.canMoveTo(x, y) || (x == 0 && y == 0));
        u.move(x, y);
    }


    public void run() {
        while (running) {

            System.out.println("\n===== MAP =====");
            map.printWithUnits(playerPos, enemyUnits); 

            System.out.println("\nJoueur 👤 : (" + playerPos.x + "," + playerPos.y + ")");
            System.out.println("Vie : " + playerUnit.getHealth());

            System.out.println("\nCommandes : w/a/s/d = bouger | f = attaquer | q = quitter");
            String cmd = sc.nextLine().trim().toLowerCase();

            if (cmd.isEmpty()) continue;

            switch (cmd.charAt(0)) {
                case 'w' -> movePlayer(0, -1);
                case 's' -> movePlayer(0, 1);
                case 'a' -> movePlayer(-1, 0);
                case 'd' -> movePlayer(1, 0);
                case 'f' -> playerAttack();
                case 'q' -> running = false;
                default -> System.out.println("Commande inconnue !");
            }

            enemyTurn();
            displayAllHealth();

            if (!playerUnit.isAlive()) {
                System.out.println("💀 GAME OVER — Le joueur est mort");
                break;
            }
            if (allEnemiesDead()) {
                System.out.println("🏆 VICTOIRE — Tous les ennemis sont morts");
                break;
            }
        }

        System.out.println("Fin du jeu.");
    }


    private void movePlayer(int dx, int dy) {
        int nx = playerPos.x + dx;
        int ny = playerPos.y + dy;

        if (map.canMoveTo(nx, ny)) {
            playerPos.x = nx;
            playerPos.y = ny;
            playerUnit.move(nx, ny);
        } else {
            System.out.println("⛔ Déplacement impossible !");
        }
    }

    private void playerAttack() {
        boolean attacked = false;
        for (Unit enemy : enemyUnits) {
            if (!enemy.isAlive()) continue;

            int dx = Math.abs(enemy.getPositionX() - playerPos.x);
            int dy = Math.abs(enemy.getPositionY() - playerPos.y);

            if (dx + dy == 1) { 
                System.out.println("⚔️ Attaque sur " + enemy.getClass().getSimpleName());
                playerUnit.attack(enemy);
                attacked = true;
            }
        }
        if (!attacked) {
            System.out.println("❌ Aucun ennemi à portée !");
        }
    }


    private void enemyTurn() {
        for (Unit enemy : enemyUnits) {
            if (!enemy.isAlive()) continue;

            moveEnemyRandomly(enemy);

            int dx = Math.abs(enemy.getPositionX() - playerPos.x);
            int dy = Math.abs(enemy.getPositionY() - playerPos.y);

            if (dx + dy == 1) {
                System.out.println(enemy.getClass().getSimpleName() + " attaque le joueur !");
                enemy.attack(playerUnit);
            }
        }
    }

    private void moveEnemyRandomly(Unit u) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int dir = random.nextInt(4);
        int nx = u.getPositionX() + dx[dir];
        int ny = u.getPositionY() + dy[dir];

        if (map.canMoveTo(nx, ny)) {
            u.move(nx, ny);
        }
    }


    private void displayAllHealth() {
        System.out.println("\n PV des unités :");
        System.out.println("👤 Joueur : " + playerUnit.getHealth());
        for (Unit enemy : enemyUnits) {
            if (enemy.isAlive()) {
                System.out.println(enemy.getClass().getSimpleName() + " : " + enemy.getHealth());
            }
        }
    }

    private boolean allEnemiesDead() {
        for (Unit u : enemyUnits) {
            if (u.isAlive()) return false;
        }
        return true;
    }
}
