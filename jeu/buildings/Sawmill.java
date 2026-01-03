package game.buildings;

import java.util.HashMap;

public class Sawmill extends Building {

    public Sawmill() {
        super(
                "Scierie",
                new HashMap<>() {
            {
                put("Or", 30);
            }
        },
                1
        );
    }

    @Override
    public void use() {
        System.out.println("🌲 Production : +25 Bois");
    }
}
