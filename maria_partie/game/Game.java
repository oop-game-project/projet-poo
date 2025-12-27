package game;

import java.util.Scanner;
import map.GameMap;
import map.Position;
import unit.Soldier;


public class Game {

    public static void main(String[] args) {

        GameMap map = new GameMap(6, 6);
        Position player = new Position(0, 0);

        Scanner sc = new Scanner(System.in);
        Soldier s1 = new Soldier("S1", new Position(0,0));
        Soldier s2 = new Soldier("S2", new Position(1,1));

        int fightbonus = map.getDefenseBonusAt(s2.getPos().x, s2.getPos().y);
        s1.attack(s2, fightbonus);

        while (true) {
            System.out.println("\n=== MAP ===");
            map.printWithPlayer(player);
            int bonus = map.getDefenseBonusAt(player.x, player.y);
            System.out.println("Defense bonus ici = " + bonus);
            System.out.println("\nPosition du joueur: (" + player.x + "," + player.y + ")");
            System.out.println("Entrez un déplacement: w=haut, s=bas, a=gauche, d=droite, q=quitter");

            String cmd = sc.nextLine().trim().toLowerCase();
            if (cmd.isEmpty()) continue;

            char c = cmd.charAt(0);

            if (c == 'q') {
                System.out.println("Fin du jeu.");
                break;
            }

            int dx = 0, dy = 0;
            switch (c) {
                case 'w': dy = -1; break;
                case 's': dy =  1; break;
                case 'a': dx = -1; break;
                case 'd': dx =  1; break;
                default:
                    System.out.println("Commande inconnue !");
                    continue;
            }

            boolean ok = map.move(player, dx, dy);
            
            if (!ok) {
            	System.out.println("✅ Mouvement OK.");
            } else {
                System.out.println("🚫 Mouvement interdit (hors map ou case non marchable).");
            
            }
            map.printWithPlayer(player);
        }

        sc.close();
    }
}