package com.viettran;

// Interface Element
interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}
