package com.viettran;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private double totalSize = 0;

    @Override
    public void visitFile(File file) {
        totalSize += file.getSize();
        System.out.println("After visiting the file " + file.getName() + " the total size is now: " + totalSize);
    }

    @Override
    public void visitDirectory(Directory directory) {
        for (FileSystemElement element : directory.getElements()) {
            element.accept(this);
        }
    }


    public double getTotalSize() {
        return totalSize;
    }
    
}
