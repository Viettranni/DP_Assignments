package com.viettran;

public class Main {
    public static void main(String[] args) {
        // Creating files
        File file1 = new File("spiderman.txt", 2);
        File file2 = new File("ant.jpg", 5);
        File file3 = new File("viet.ppt", 10);
        File file4 = new File("saed.txt", 1);

        // Create directories
        Directory rootDir = new Directory("root");
        Directory subDir = new Directory("subdir");

        // Build file structure
        rootDir.addFile(file1);
        rootDir.addFile(file2);
        subDir.addFile(file3);
        subDir.addFile(file4);
        rootDir.addFile(subDir);

        // Apply SizeCalculatorVisitor
        SizeCalculatorVisitor sizeCalculatorVisitor = new SizeCalculatorVisitor();
        rootDir.accept(sizeCalculatorVisitor);
        System.out.println("Total Size: " + sizeCalculatorVisitor.getTotalSize() + " MB");

        // Apply SearchVisitor (searching for .txt files)

        System.out.println("MOVING ON TO SEARCHING");
        SearchVisitor searchVisitor = new SearchVisitor(".txt");
        rootDir.accept(searchVisitor);
        System.out.println("Files matching '.txt':");
        for (File file : searchVisitor.getMatchedFiles()) {
            System.out.println("- " + file.getName());
        }
    }
}