package map;

import java.util.Random;
import units.Unit;
import java.util.List;

public class GameMap {
	private final int width;
    private final int height;
    private final Tile[][] grid;
    private final Random random = new Random();

    public GameMap(int width, int height, boolean randomMap) {
        this.width = width;
        this.height = height;
        this.grid = new Tile[height][width];
        if (randomMap) {
            generateRandom();
        } else {
            generateStatic();
        }
    }

    private void generateStatic() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid[y][x] = new Tile(TileType.GRASS);
            }
        }

        if (width > 3 && height > 3) {
            grid[1][2] = new Tile(TileType.WATER);
            grid[2][1] = new Tile(TileType.MOUNTAIN);
            grid[2][3] = new Tile(TileType.WATER);
        }
    }

    private void generateRandom() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int r = random.nextInt(100);
                TileType type = (r < 70) ? TileType.GRASS
                                : (r < 85) ? TileType.MOUNTAIN
                                : TileType.WATER;
                grid[y][x] = new Tile(type);
            }
        }
    }
    
    public boolean isInside(int x, int y) {
        return x >= 0 && y >= 0 && x < width && y < height;
    }

    public Tile getTile(int x, int y) {
        if (!isInside(x, y)) {
            return null;
        }
        return grid[y][x];
    }

    public boolean canMoveTo(int x, int y) {
        if (!isInside(x, y)) {
            return false;
        }
        return grid[y][x].isWalkable();
    }

    public void print() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(grid[y][x].toSymbol() + " ");
            }
            System.out.println();
        }
    }

    public boolean move(Position pos, int dx, int dy) {
        int nx = pos.x + dx;
        int ny = pos.y + dy;

        if (!canMoveTo(nx, ny)) {
            return false;
        }

        pos.x = nx;
        pos.y = ny;
        return true;
    }

    public void printWithPlayer(Position playerPos) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (x == playerPos.x && y == playerPos.y) {
                    System.out.print("👤");
                } else {
                    System.out.print(grid[y][x].toSymbol() + " ");
                }
            }
            System.out.println();
        }
    }

    public int getDefenseBonusAt(int x, int y) {
        if (!isInside(x, y)) {
            return 0;
        }
        return grid[y][x].getDefenseBonus();
    }
    
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    private char getUnitSymbol(Unit u) {
        return switch (u.getType()) {
            case "Tank" -> 'T';
            case "Soldier" -> 'S';
            case "Archer" -> 'A';
            case "Magicien" -> 'M';
            case "Cavalier" -> 'C';
            default -> '?';
        };
    }

    
    public void printWithUnits(Position playerPos, List<Unit> units) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                if (x == playerPos.x && y == playerPos.y) {
                    System.out.print("👤 ");
                    continue;
                }

                boolean printed = false;
                for (Unit u : units) {
                    if (u.isAlive() && u.getPositionX() == x && u.getPositionY() == y) {
                        System.out.print(getUnitSymbol(u) + " ");
                        printed = true;
                        break;
                    }
                }

                if (!printed) {
                    System.out.print(grid[y][x].toSymbol() + " ");
                }
            }
            System.out.println();
        }
    }

}
