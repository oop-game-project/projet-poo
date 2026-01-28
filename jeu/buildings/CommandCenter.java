package buildings;

import java.util.HashMap;

public class CommandCenter extends Building {

    public CommandCenter() {
        super(
                "Centre de Commandement",
                new HashMap<>() {
            {
                put("Or", 100);
                put("Bois", 50);
            }
        },
                3
        );
    }

    @Override
    public void use() {
        System.out.println("📍 Centre de commandement opérationnel.");
    }
}
