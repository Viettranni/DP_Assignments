package com.viettran;

import java.time.LocalDate;

public class Document implements DocumentInterface {
    private final int id;
    private final LocalDate creationDate;
    private final String content;

    public Document(int id, String content) {
        this.id = id;
        this.creationDate = LocalDate.now();
        this.content = content;
    }

    public int getId() {
        return id;
    }

    @Override
    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public String getContent(User user) {
        return content; 
    }
}

