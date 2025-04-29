package com.viettran;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Recommendation> recommendations = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Sample data
        Book book1 = new Book("J.K. Rowling", "Harry Potter", "Fantasy", 1997);
        Book book2 = new Book("George Orwell", "1984", "Dystopian", 1949);

        List<Book> fantasyBooks = new ArrayList<>();
        List<Book> horrorBooks = new ArrayList<>();
        fantasyBooks.add(book1);
        fantasyBooks.add(book2);

        Recommendation fantasyRecommendation = new Recommendation("Fantasy Lovers", fantasyBooks);
        Recommendation horrorRecommendation = new Recommendation("Horror Lovers", horrorBooks);
        recommendations.add(fantasyRecommendation);
        recommendations.add(horrorRecommendation);

        boolean running = true;

        while (running) {
            System.out.println("\n--- Book Recommendation System ---");
            System.out.println("1. View all recommendations");
            System.out.println("2. Clone and modify a recommendation");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> viewRecommendations();
                case 2 -> cloneAndModifyRecommendation();
                case 3 -> {
                    System.out.println("Exiting system.");
                    running = false;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void viewRecommendations() {
        if (recommendations.isEmpty()) {
            System.out.println("No recommendations available.");
            return;
        }

        for (int i = 0; i < recommendations.size(); i++) {
            System.out.println("[" + i + "] " + recommendations.get(i).getTargetAudience());
            for (Book book : recommendations.get(i).clone().books) {
                book.printBook();
            }
        }
    }

    private static void cloneAndModifyRecommendation() {
        viewRecommendations();
        System.out.print("Enter index of recommendation to clone: ");
        int index = Integer.parseInt(scanner.nextLine());

        if (index < 0 || index >= recommendations.size()) {
            System.out.println("Invalid index.");
            return;
        }

        Recommendation original = recommendations.get(index);
        Recommendation cloned = original.clone();

        System.out.print("Enter new target audience: ");
        String newAudience = scanner.nextLine();
        cloned.setNewTargetAudience(newAudience);

        boolean modifying = true;
        while (modifying) {
            System.out.println("\n1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Finish and save");
            System.out.print("Choose: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Publication Year: ");
                    int year = Integer.parseInt(scanner.nextLine());
                    cloned.addBook(new Book(author, title, genre, year));
                }
                case 2 -> {
                    for (int i = 0; i < cloned.clone().books.size(); i++) {
                        System.out.print("[" + i + "] ");
                        cloned.clone().books.get(i).printBook();
                    }
                    System.out.print("Enter index of book to remove: ");
                    int removeIndex = Integer.parseInt(scanner.nextLine());
                    if (removeIndex >= 0 && removeIndex < cloned.clone().books.size()) {
                        cloned.removeBook(cloned.clone().books.get(removeIndex));
                    } else {
                        System.out.println("Invalid index.");
                    }
                }
                case 3 -> {
                    recommendations.add(cloned);
                    modifying = false;
                    System.out.println("Cloned recommendation saved.");
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
