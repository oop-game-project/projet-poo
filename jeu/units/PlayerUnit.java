package units;

public class PlayerUnit extends Unit {

    public PlayerUnit(String type, int x, int y) {
        super(100, type, getWeapon(type), getAttack(type), getDefense(type), x, y, getRange(type));
    }

    @Override
    public void attack(Unit target) {
        if (target != null && target.isAlive() && isInRange(target)) {
            target.takeDamage(this.attackPower);
        }
    }

    @Override
    public String getType() {
        return name; // le type choisi
    }

    public boolean isInRange(Unit target) {
        int distance = Math.abs(this.positionX - target.positionX) + Math.abs(this.positionY - target.positionY);
        return distance <= range;
    }

    // Méthodes pour définir stats selon type choisi
    private static String getWeapon(String type) {
        return switch(type) {
            case "Soldier" -> "Pistolet";
            case "Archer" -> "Arc";
            case "Tank" -> "Canon";
            case "Magicien" -> "Baguette";
            case "Cavalier" -> "Épée";
            default -> "Poing";
        };
    }

    private static int getAttack(String type) {
        return switch(type) {
            case "Soldier" -> 20;
            case "Archer" -> 15;
            case "Tank" -> 30;
            case "Magicien" -> 20;
            case "Cavalier" -> 25;
            default -> 10;
        };
    }

    private static int getDefense(String type) {
        return switch(type) {
            case "Soldier" -> 10;
            case "Archer" -> 5;
            case "Tank" -> 10;
            case "Magicien" -> 20;
            case "Cavalier" -> 15;
            default -> 5;
        };
    }

    private static int getRange(String type) {
        return switch(type) {
            case "Soldier" -> 1;
            case "Archer" -> 3;
            case "Tank" -> 2;
            case "Magicien" -> 3;
            case "Cavalier" -> 1;
            default -> 1;
        };
    }
}
