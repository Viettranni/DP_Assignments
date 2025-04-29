package com.viettran;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameApp extends Application {
    // Constants defining the tile size and map dimensions
    private static final int TILE_DIMENSION = 32;
    private static final int MAP_WIDTH = 20;
    private static final int MAP_HEIGHT = 15;

    @Override
    public void start(Stage primaryStage) {
        // Generate the map using the specified dimensions
        Tile[][] gameMap = MapGenerator.createMap(MAP_WIDTH, MAP_HEIGHT);

        // Create a canvas for rendering the map
        Canvas gameCanvas = new Canvas(MAP_WIDTH * TILE_DIMENSION, MAP_HEIGHT * TILE_DIMENSION);
        GraphicsContext graphicsContext = gameCanvas.getGraphicsContext2D();
        
        // Render the game map onto the canvas
        MapRenderer.render(graphicsContext, gameMap, TILE_DIMENSION);

        // Set up the scene and root pane
        Pane rootPane = new Pane(gameCanvas);
        Scene scene = new Scene(rootPane);

        // Set up the primary stage (window) and display the game
        primaryStage.setTitle("RPG Game - Full Flyweight");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
