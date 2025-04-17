package com.viettran;

public class File implements FileSystemElement{

    private double size;
    private String name;

    public File(String name, double size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visitFile(this);
    }

    public double getSize() {
        return size;
    }

    public String getName() {
        return name;
    }
    
}
