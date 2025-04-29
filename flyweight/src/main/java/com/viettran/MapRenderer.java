package com.viettran;

import javafx.scene.canvas.GraphicsContext;

public class MapRenderer {
    
    // Renders the map on the canvas by drawing each tile
    public static void render(GraphicsContext graphicsContext, Tile[][] tileMap, int tileDimension) {
        // Iterate over each row in the map
        for (int row = 0; row < tileMap.length; row++) {
            // Iterate over each column in the current row
            for (int column = 0; column < tileMap[row].length; column++) {
                // Retrieve the tile at the current position
                Tile currentTile = tileMap[row][column];
                
                // Draw the image of the tile at the specified position and size
                graphicsContext.drawImage(
                    currentTile.getTileType().getTileImage(),
                    currentTile.getPosX() * tileDimension,
                    currentTile.getPosY() * tileDimension,
                    tileDimension,
                    tileDimension
                );
            }
        }
    }
}
