package com.example;

import java.util.Random;

public class CityMap extends Map {
    public CityMap(int height, int width) {
        super(height, width);
    }

    // Creates the tiles according to the instructions and taking into consider the map type
    @Override
    public Tile createTile() {
        Random randomNumber = new Random();
        int randomTile = randomNumber.nextInt(3);

        switch (randomTile) {
            case 0: 
                return new BuildingTile();
            case 1:
                return new ForestTile();
            case 2:
                return new RoadTile();
            default:
                return new BuildingTile();
        }
    }
}
