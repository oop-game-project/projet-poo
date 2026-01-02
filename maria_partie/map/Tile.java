package map;

public class Tile {
    private final TileType type;
    private final boolean walkable;
    private final int defenseBonus;

    public Tile(TileType type) {
        this.type = type;

        switch (type) {
            case GRASS -> { walkable = true;  defenseBonus = 0; }
            case MOUNTAIN -> { walkable = true; defenseBonus = 2; }
            case WATER -> { walkable = false; defenseBonus = 0; }
            default -> { walkable = true; defenseBonus = 0; }
        }
    }

    public TileType getType() { return type; }
    public boolean isWalkable() { return walkable; }
    public int getDefenseBonus() { return defenseBonus; }

    
    public String toSymbol() {
        return switch (type) {
           case GRASS -> "🍀";
        case WATER -> "🌊";
        case MOUNTAIN -> "⛰️";  
        }
    }
    public int getDefenseBonus1() {
        switch (type) {
            case MOUNTAIN: return 2;
            case GRASS: return 0;
            default: return 0;
        }
    }
}
