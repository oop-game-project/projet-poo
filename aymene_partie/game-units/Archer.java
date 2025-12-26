package game.units;
import game.units.Unit;

public class Archer extends Unit {

    private int range = 3;

    public Archer(int positionX, int positionY) {
        super(100, "Archer", "Arc", 15, 5, positionX, positionY);
    }

    public String getType() {
        return "Archer";
    }

    public void attack(Unit target) {
        if (target != null && target.isAlive() && isInRange(target)) {
            target.takeDamage(this.attackPower);
        }
    }

    public boolean isInRange(Unit target) {
        int distance = Math.abs(this.positionX - target.positionX) + Math.abs(this.positionY - target.positionY);
        return distance <= range;
    }

}
