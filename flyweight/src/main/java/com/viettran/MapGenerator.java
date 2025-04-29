package com.viettran;

import java.util.Random;

public class MapGenerator {
    private static final Random rng = new Random();

    public static Tile[][] createMap(int cols, int rows) {
        Tile[][] mapGrid = new Tile[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                mapGrid[row][col] = generateRandomTile(col, row);
            }
        }
        return mapGrid;
    }

    private static Tile generateRandomTile(int x, int y) {
        int choice = rng.nextInt(3);
        switch (choice) {
            case 0:
                return TileInstanceFactory.createTile(x, y, "forest", 'F');
            case 1:
                return TileInstanceFactory.createTile(x, y, "desert", 'D');
            case 2:
                return TileInstanceFactory.createTile(x, y, "water", 'W');
            default:
                return TileInstanceFactory.createTile(x, y, "forest", 'F');
        }
    }

}
