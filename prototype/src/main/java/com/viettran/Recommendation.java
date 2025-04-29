package com.viettran;

import java.util.ArrayList;
import java.util.List;

public class Recommendation {
    private String targetAudience;
    List<Book> books = new ArrayList<>();

    // Constructor
    public Recommendation(String targetAudience, List<Book> books) {
        this.targetAudience = targetAudience;
        this.books = books;
    }

    // Clone
    public Recommendation clone() {
        List<Book> copiedBooks = new ArrayList<>();
            for (Book book : this.books) {
                copiedBooks.add(book.clone());
            }

        return new Recommendation(this.targetAudience, copiedBooks);
    }

    // Set new target audience
    public void setNewTargetAudience(String newAudience) {
        this.targetAudience = newAudience;
    }

    // Add books
    public void addBook(Book book) {
        books.add(book);
    }

    // Remove book
    public void removeBook(Book book) {
        books.remove(book);
    }

    // Getters
    public String getTargetAudience() {
        return targetAudience;
    }
    
}
