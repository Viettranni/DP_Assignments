package com.viettranni;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PixelArtEditor extends Application {
    public static final int SIZE = 8;
    public static final int CELL_SIZE = 40;

    public int[][] grid = new int[SIZE][SIZE];
    public int cursorX = 0;
    public int cursorY = 0;
    public Canvas canvas = new Canvas(SIZE * CELL_SIZE, SIZE * CELL_SIZE);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        VBox controls = new VBox();

        drawGrid();

        Button generateCodeButton = new Button("Create Code");
        generateCodeButton.setOnAction(e -> new GenerateCodeCommand(this).execute());
        controls.getChildren().add(generateCodeButton);

        root.setCenter(canvas);
        root.setBottom(controls);

        Scene scene = new Scene(root);
        scene.setOnKeyPressed(event -> {
            // Printing the pressed key to ensure the correctness
            System.out.println("Key Pressed: " + event.getCode());
            Command command = null;
            if (event.getCode() == KeyCode.UP) command = new MoveCursorUpCommand(this);
            else if (event.getCode() == KeyCode.DOWN) command = new MoveCursorDownCommand(this);
            else if (event.getCode() == KeyCode.LEFT) command = new MoveCursorLeftCommand(this);
            else if (event.getCode() == KeyCode.RIGHT) command = new MoveCursorRightCommand(this);
            else if (event.getCode() == KeyCode.SPACE) command = new TogglePixelCommand(this);
            if (command != null) command.execute();
        });

        stage.setTitle("Pixel Art Editor");
        stage.setScene(scene);
        stage.show();

        // Ensure the window remains focused and active
        Platform.runLater(() -> stage.requestFocus());
    }

    public void drawGrid() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        // Draw the grid cells
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                if (grid[y][x] == 1) {
                    gc.setFill(javafx.scene.paint.Color.BLACK);  
                    gc.fillRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                } else {
                    gc.setFill(javafx.scene.paint.Color.WHITE);
                    gc.fillRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
            }
        }
        
        gc.setStroke(javafx.scene.paint.Color.RED);  
        gc.setLineWidth(2); 
        gc.strokeRect(cursorX * CELL_SIZE, cursorY * CELL_SIZE, CELL_SIZE, CELL_SIZE);
    }
    
}
