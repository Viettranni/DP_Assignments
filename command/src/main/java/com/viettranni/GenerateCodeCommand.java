package com.viettranni;

public class GenerateCodeCommand implements Command {
    private PixelArtEditor editor;

    public GenerateCodeCommand(PixelArtEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        System.out.println("int[][] pixelArt = {");
        for (int y = 0; y < PixelArtEditor.SIZE; y++) {
            System.out.print("    {");
            for (int x = 0; x < PixelArtEditor.SIZE; x++) {
                System.out.print(editor.grid[y][x]);
                if (x < PixelArtEditor.SIZE - 1) System.out.print(", ");
            }
            System.out.println(y < PixelArtEditor.SIZE - 1 ? "}," : "}");
        }
        System.out.println("};");
    }
}

