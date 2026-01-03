package game.buildings;

public abstract class Building {

    protected String name;
    protected int level;
    protected int cost;

    public Building(String name, int cost) {
        this.name = name;
        this.cost = cost;
        this.level = 1;
    }

    public void upgrade() {
        level++;
        System.out.println(name + " upgraded to level " + level);
    }
}
