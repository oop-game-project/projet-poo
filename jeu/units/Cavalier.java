package units;

public class Cavalier extends Unit {

    public Cavalier(int positionX, int positionY) {
        super(100, "Cavalier", "Épée", 25, 15, positionX, positionY, 1);
    }

    public String getType() {
        return "Cavalier";
    }

    public void attack(Unit target) {
        if (target != null && target.isAlive()) {
            target.takeDamage(this.attackPower);
        }
    }
}
