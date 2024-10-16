package com.library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book '" + book.getTitle() + "' added to the library.");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("Available books:");
            for (Book book : books) {
                System.out.println("- " + book.getTitle() + (book.isBorrowed() ? " (Borrowed)" : ""));
            }
        }
    }

    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isBorrowed()) {
                    book.borrow();
                    System.out.println("You have borrowed the book '" + book.getTitle() + "'.");
                } else {
                    System.out.println("The book '" + book.getTitle() + "' is already borrowed.");
                }
                return;
            }
        }
        System.out.println("The book '" + title + "' is not available in the library.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isBorrowed()) {
                    book.returnBook();
                    System.out.println("You have returned the book '" + book.getTitle() + "'.");
                } else {
                    System.out.println("The book '" + book.getTitle() + "' was not borrowed.");
                }
                return;
            }
        }
        System.out.println("The book '" + title + "' is not available in the library.");
    }
}

