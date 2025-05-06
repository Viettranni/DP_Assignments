package com.viettranni;

public class MoveCursorLeftCommand implements Command {
    private PixelArtEditor editor;

    public MoveCursorLeftCommand(PixelArtEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        if (editor.cursorX > 0) {
            editor.cursorX--;
            editor.drawGrid();
        }
    }
}
