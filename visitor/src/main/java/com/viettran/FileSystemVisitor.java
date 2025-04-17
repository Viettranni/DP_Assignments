package com.viettran;

// Interface Visitor
interface FileSystemVisitor {
    void visitFile(File file);
    void visitDirectory(Directory directory);
}
