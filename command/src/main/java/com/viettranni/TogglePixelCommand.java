package com.viettranni;

public class TogglePixelCommand implements Command {
    private PixelArtEditor editor;

    public TogglePixelCommand(PixelArtEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        int x = editor.cursorX;
        int y = editor.cursorY;
        editor.grid[y][x] = editor.grid[y][x] == 0 ? 1 : 0;
        editor.drawGrid();
    }
}
