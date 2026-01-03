package game.player;

import java.util.HashMap;
import java.util.Map;

public class Player {

    private String name;
    private Map<String, Integer> resources;

    public Player(String name) {
        this.name = name;
        resources = new HashMap<>();
        resources.put("Gold", 1000);
        resources.put("Wood", 500);
        resources.put("Food", 300);
    }

    public void addResource(String resource, int amount) {
        resources.put(resource, resources.getOrDefault(resource, 0) + amount);
    }

    public boolean spendResource(String resource, int amount) {
        if (resources.getOrDefault(resource, 0) >= amount) {
            resources.put(resource, resources.get(resource) - amount);
            return true;
        }
        return false;
    }

    public void showResources() {
        System.out.println("Resources: " + resources);
    }
}
