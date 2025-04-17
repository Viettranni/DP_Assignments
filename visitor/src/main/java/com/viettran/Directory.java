package com.viettran;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemElement {
    private String name;
    private List<FileSystemElement> elements;

    public Directory(String name) {
        this.name = name;
        this.elements = new ArrayList<>();
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visitDirectory(this);
    }

    // Adding element to the List
    public void addFile(FileSystemElement element) {
        elements.add(element);
    }

    // Getting the name of the directory
    public String getName() {
        return name;
    }

    public List<FileSystemElement> getElements() {
        return elements;
    }
}
