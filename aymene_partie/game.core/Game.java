package game.core;

import game.units.Unit;

public class Game {

    private Unit[] units;
    private int unitCount;

    public Game(int maxUnits) {
        units = new Unit[maxUnits];
        unitCount = 0;

    }

    public void addUnit(Unit unit) {
        if (unitCount < units.length) {
            units[unitCount] = unit;
            unitCount++;
        } else {
            System.out.println("Nombre maximal d'unités atteint !");
        }
    }

    public Unit[] getUnits() {
        return units;
    }

    public int getUnitCount() {
        return unitCount;
    }

    public void attack(Unit attacker, Unit target) {
        if (attacker != null && target != null && attacker.isAlive()) {
            attacker.attack(target);
        }
    }

    public boolean isGameOver() {
        int aliveUnits = 0;

        for (int i = 0; i < unitCount; i++) {
            if (units[i].isAlive()) {
                aliveUnits++;
            }
        }
        return aliveUnits <= 1;
    }
}
