package com.viettran;

import javafx.scene.image.Image;

public class TileType {
    private final String typeName;
    private final char tileSymbol;
    private final Image tileImage;   

    // Constructor to initialize the tile type with a name, symbol, and image
    public TileType(String typeName, char tileSymbol, Image tileImage) {
        this.typeName = typeName;
        this.tileSymbol = tileSymbol;
        this.tileImage = tileImage;
    }

    // Getter for the name of the tile type
    public String getTypeName() {
        return typeName;
    }

    // Getter for the symbol representing the tile type
    public char getTileSymbol() {
        return tileSymbol;
    }

    // Getter for the image associated with the tile type
    public Image getTileImage() {
        return tileImage;
    }
}
