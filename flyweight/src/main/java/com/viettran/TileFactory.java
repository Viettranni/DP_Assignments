package com.viettran;

import javafx.scene.image.Image;
import java.util.HashMap;
import java.util.Map;

public class TileFactory {
    private static final Map<String, TileType> tileTypes = new HashMap<>();

    public static TileType getTileType(String name, char symbol) {
        if (!tileTypes.containsKey(name)) {
            String imagePath = "/images/" + name + ".png"; 
            var imageUrl = TileFactory.class.getResource(imagePath);

            if (imageUrl == null) {
                throw new IllegalArgumentException("Image not found: " + imagePath);
            }

            Image image = new Image(imageUrl.toString());
            TileType type = new TileType(name, symbol, image);
            tileTypes.put(name, type);
        }
        return tileTypes.get(name);
    }
}
