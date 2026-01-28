package units;

public class Tank extends Unit {

    private int range = 2;

    public Tank(int positionX, int positionY) {
        super(100, "tank", "Canon", 30, 10, positionX, positionY, 2);
    }

    public String getType() {
        return "Tank";
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
