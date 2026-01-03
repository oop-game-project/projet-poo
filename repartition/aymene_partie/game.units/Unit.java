package game.units;

public abstract class Unit {

    protected int health;
    protected String name;
    protected int attackPower;
    protected int defense;
    protected int positionX;
    protected int positionY;
    protected String arme_name;

    public Unit(int health, String name, String arme_name, int attackPower, int defense, int positionX, int positionY) {
        this.health = health;
        this.name = name;
        this.arme_name = arme_name;
        this.attackPower = attackPower;
        this.defense = defense;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public Unit() {
        this.health = 0;
        this.name = "unknown";
        this.arme_name = "unknown";
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
            realDamage = 0;
        }
        health -= realDamage;
        if (health < 0) {
            health = 0;
        }
    }

    public abstract void attack(Unit target);

    public abstract String getType();

    public void affichage() {
        System.out.println("Type: " + getType());
        System.out.println("Arme: " + arme_name);
        System.out.println("Health: " + health);
    }

    // Getters and Setters
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArme_name() {
        return arme_name;
    }

    public void setArme_name(String arme_name) {
        this.arme_name = arme_name;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

}
