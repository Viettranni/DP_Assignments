package com.viettran;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Add documents
        library.addUnprotectedDocument(1, "Public Document Content");
        library.addProtectedDocument(2, "Top Secret Document", new String[]{"alice", "bob"});

        User alice = new User("alice");
        User charlie = new User("charlie");

        try {
            System.out.println("Alice reads public doc: " + library.getDocument(1).getContent(alice));
            System.out.println("Alice reads protected doc: " + library.getDocument(2).getContent(alice));
            System.out.println("Charlie reads protected doc: " + library.getDocument(2).getContent(charlie));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}
