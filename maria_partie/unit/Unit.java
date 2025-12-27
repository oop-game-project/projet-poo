package unit;

import map.Position;

public abstract class Unit {
    protected String name;
    protected int hp;
    protected int attack;
    protected int defense;
    protected Position pos;

    public Unit(String name, int hp, int attack, int defense, Position pos) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.pos = pos;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    
    public abstract void attack(Unit target, int terrainDefenseBonus);
}