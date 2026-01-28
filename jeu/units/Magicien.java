package units;

public class Magicien extends Unit {

    public Magicien(int x, int y) {
        super(100, "Magicien", "baguette magique", 20, 20, x, y, 3);
    }

    public String getType() {
        return "Magicien";
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


