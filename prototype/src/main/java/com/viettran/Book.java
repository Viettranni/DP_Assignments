package com.viettran;


public class Book {
    private String author;
    private String title;
    private String genre;
    private Integer publicationYear;

    // Constructor
    public Book(String author, String title, String genre, Integer publicationYear) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    public void printBook() {
        System.out.println("The book is: " + author + ", " + title + ", " + genre + ", " + publicationYear + ".");
    }

    // Clone
    public Book clone() {
        String copyAuthor = this.author;
        String copyTitle = this.title;
        String copyGenre = this.genre;
        Integer copyPublicationYear = this.publicationYear;

        return new Book(copyAuthor, copyTitle, copyGenre, copyPublicationYear);
    }
}
