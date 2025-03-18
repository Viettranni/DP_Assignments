package com.example;

import java.util.Random;

public class WildernessMap extends Map {
    public WildernessMap(int height, int width) {
        super(height, width);
    }

    // Creates the tiles according to the instructions and taking into consider the map type
    @Override
    public Tile createTile() {
        Random randomNumber = new Random();
        int randomTile = randomNumber.nextInt(3);

        switch (randomTile) {
            case 0: 
                return new SwampTile();
            case 1:
                return new WaterTile();
            case 2:
                return new RoadTile();
            default:
                return new SwampTile();
        }
    }
}
