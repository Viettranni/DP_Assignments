package com.viettranni;

public class MoveCursorRightCommand implements Command {
    private PixelArtEditor editor;

    public MoveCursorRightCommand(PixelArtEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        if (editor.cursorX < PixelArtEditor.SIZE - 1) {
            editor.cursorX++;
            editor.drawGrid();
        }
    }
}
