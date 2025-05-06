package com.viettranni;

public class MoveCursorUpCommand implements Command {
    private PixelArtEditor editor;

    public MoveCursorUpCommand(PixelArtEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        if (editor.cursorY > 0) {
            editor.cursorY--;
            editor.drawGrid();
        }
    }
}
