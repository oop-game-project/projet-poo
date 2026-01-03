package game.buildings;

import java.util.HashMap;

public class Mine extends Building {

    public Mine() {
        super(
                "Mine",
                new HashMap<>() {
            {
                put("Bois", 30);
            }
        },
                1
        );
    }

    @Override
    public void use() {
        System.out.println("⛏️ Production : +20 Pierre");
    }
}
