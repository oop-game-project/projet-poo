package game.units;

public class Solider extends Unit {

    public Solider(int positionX, int positionY) {
        super(100, "Soldier", "Pistolet", 20, 10, positionX, positionY);
    }

    public String getType() {
        return "Soldier";
    }

    public void attack(Unit target){
        if (target != null && target.isAlive()) {
            target.takeDamage(this.attackPower);
        }
    }
}
