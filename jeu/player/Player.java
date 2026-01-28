package player;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Player {

    private String name;
    private final Map<String, Integer> resources;

    public Player(String name) {
        this.name = name;
        resources = new HashMap<>();
        resources.put("Gold", 1000);
        resources.put("Wood", 500);
        resources.put("Food", 300);
    }

    public void addResource(String resource, int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        resources.put(resource, resources.getOrDefault(resource, 0) + amount);
    }

    public boolean spendResource(String resource, int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        int current = resources.getOrDefault(resource, 0);
        if (current >= amount) {
            resources.put(resource, current - amount);
            return true;
        }
        return false; 
    }

    public void showResources() {
        System.out.println("Player: " + name);
        resources.forEach((res, amount) -> System.out.println("  " + res + ": " + amount));
    }

    public Map<String, Integer> getResources() {
        return Collections.unmodifiableMap(resources);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
