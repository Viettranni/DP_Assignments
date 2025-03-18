package com.example;

public abstract class Map {
    public Tile[] arrayTiles;
    public int height;
    public int width;

    // Constructor
    public Map(int height, int width) {
        this.height = height;
        this.width = width;
        this.arrayTiles = new Tile[height * width];

        assignTilesToArray();
    }

    public abstract Tile createTile();

    public void display(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // Index creates the 2D Matrix
                int index = i * width + j;
                System.out.print(arrayTiles[index].getCharacter() + " ");
            }
            System.out.println();
        }
    }

    // Filling the Array with random Tiles
    public void assignTilesToArray() {
        int totalTiles = height * width;
        for (int i = 0; i < totalTiles; i++) {
            // Assigning random Tiles
            arrayTiles[i] = createTile();
        }
    }
    
} 


