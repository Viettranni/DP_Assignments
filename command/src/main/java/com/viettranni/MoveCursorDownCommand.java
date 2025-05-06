package com.viettranni;

public class MoveCursorDownCommand implements Command {
    private PixelArtEditor editor;

    public MoveCursorDownCommand(PixelArtEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        if (editor.cursorY < PixelArtEditor.SIZE - 1) {
            editor.cursorY++;
            editor.drawGrid();
        }
    }
}

