package game-units;

public abstract class Unit {

    protected int health;
    protected String name;
    protected int attackPower;
    protected int defense;
    protected int positionX;
    protected int positionY;

    public Unit(int health, String name, int attackPower, int defense, int positionX, int positionY) {
        this.health = health;
        this.name = name;
        this.attackPower = attackPower;
        this.defense = defense;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public Unit() {
        this.health = 0;
        this.name = "unknown";
        this.attackPower = 0;
        this.defense = 0;
        this.positionX = 0;
        this.positionY = 0;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void move(int x, int y) {
        this.positionX = x;
        this.positionY = y;
    }

    public void takeDamage(int attackPower) {
        int realDamage = attackPower - defense;
        if (realDamage < 0) {
            realDamage = 0 ;
        }
        if (realDamage > health) {
            health = 0;
        }
    }


}
