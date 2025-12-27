package game.ui;

import java.util.Scanner;

public class ConsoleUI {

    private Scanner scanner = new Scanner(System.in);

    public void showMainMenu() {
        System.out.println("===== JEU STRATÉGIQUE =====");
        System.out.println("1. Nouvelle Partie");
        System.out.println("2. Quitter");
        System.out.print("Choix : ");
    }

    public int getChoice() {
        return scanner.nextInt();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
