package com.viettran;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private String searchPattern;
    private List<File> matchedFiles = new ArrayList<>();
    
    public SearchVisitor(String searchPattern) {
        this.searchPattern = searchPattern;
    }

    public List<File> getMatchedFiles() {
        return matchedFiles;
    }

    @Override
    public void visitFile(File file) {
        if (file.getName().contains(searchPattern)) {
            matchedFiles.add(file);
        }
    }

    @Override
    public void visitDirectory(Directory directory) {
        for (FileSystemElement element : directory.getElements()) {
            element.accept(this);
        }
    }
}
