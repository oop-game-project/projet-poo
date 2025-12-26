package map;

import java.util.Random;

public class GameMap {
    private final int width;
    private final int height;
    private final Tile[][] grid;
    private final Random random = new Random();

    public GameMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new Tile[height][width];
        generateRandom(); 
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

    
    @SuppressWarnings("unused")
    private void generateRandom() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int r = random.nextInt(100);
                TileType type =
                        (r < 70) ? TileType.GRASS :
                        (r < 85) ? TileType.MOUNTAIN :
                                   TileType.WATER;
                grid[y][x] = new Tile(type);
            }
        }
    }

    public boolean isInside(int x, int y) {
        return x >= 0 && y >= 0 && x < width && y < height;
    }

    public Tile getTile(int x, int y) {
        if (!isInside(x, y)) return null;
        return grid[y][x];
    }

    
    public boolean canMoveTo(int x, int y) {
        if (!isInside(x, y)) return false;
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
 // Déplacer une "position" si la case est autorisée
    public boolean move(Position pos, int dx, int dy) {
        int nx = pos.x + dx;
        int ny = pos.y + dy;

        if (!canMoveTo(nx, ny)) return false;

        pos.x = nx;
        pos.y = ny;
        return true;
    }

    // Afficher la carte avec la position du joueur (P)
    public void printWithPlayer(Position playerPos) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (x == playerPos.x && y == playerPos.y) {
                    System.out.print("P ");
                } else {
                    System.out.print(grid[y][x].toSymbol() + " ");
                }
            }
            System.out.println();
        }
    }
    public int getDefenseBonusAt(int x, int y) {
        if (!isInside(x, y)) return 0;
        return grid[y][x].getDefenseBonus();
    }
}
