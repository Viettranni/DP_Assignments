package com.viettran;

public class Tile {
    private final int posX; 
    private final int posY; 
    private final TileType tileType;   

    // Constructor to initialize the tile with position and type
    public Tile(int posX, int posY, TileType tileType) {
        this.posX = posX;
        this.posY = posY;
        this.tileType = tileType;
    }

    // Getter for the X position of the tile
    public int getPosX() {
        return posX;
    }

    // Getter for the Y position of the tile
    public int getPosY() {
        return posY;
    }

    // Getter for the type of the tile
    public TileType getTileType() {
        return tileType;
    }
}
