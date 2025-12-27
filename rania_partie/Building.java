package game.buildings;

import java.util.Map;

public abstract class Building {

    protected String name;
    protected Map<String, Integer> cost;
    protected int buildTime;

    public Building(String name, Map<String, Integer> cost, int buildTime) {
        this.name = name;
        this.cost = cost;
        this.buildTime = buildTime;
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getCost() {
        return cost;
    }

    public abstract void use();
}
