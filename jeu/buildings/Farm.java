package buildings;

import java.util.HashMap;

public class Farm extends Building {

    public Farm() {
        super(
                "Ferme",
                new HashMap<>() {
            {
                put("Bois", 20);
            }
        },
                1
        );
    }

    @Override
    public void use() {
        System.out.println("🌾 Production : +15 Nourriture");
    }
}
