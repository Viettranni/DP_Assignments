package com.viettran;

public class TileInstanceFactory {
    // This would create the new tile
    public static Tile createTile(int x, int y, String typeName, char symbol) {
        TileType type = TileFactory.getTileType(typeName, symbol);
        return new Tile(x, y, type);
    }
}