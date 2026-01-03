package game.buildings;

import java.util.HashMap;

public class TrainingCamp extends Building {

    public TrainingCamp() {
        super(
                "Camp d'entraînement",
                new HashMap<>() {
            {
                put("Or", 80);
                put("Bois", 40);
            }
        },
                2
        );
    }

    @Override
    public void use() {
        System.out.println("⚔️ Une unité est entraînée.");
    }
}
