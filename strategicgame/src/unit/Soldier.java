package unit;

import map.Position;

public class Soldier extends Unit {

    public Soldier(String name, Position pos) {
        super(name, 20, 8, 2, pos);
    }

    @Override
    public void attack(Unit target, int terrainDefenseBonus) {
        int damage = this.attack - (target.defense + terrainDefenseBonus);
        if (damage < 0) damage = 0;

        target.hp -= damage;

        System.out.println(this.name + " attaque " + target.name +
                " | dégâts=" + damage + " | HP de " + target.name + "=" + target.hp);
    }
}