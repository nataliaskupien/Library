package models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String firstName;
    private String lastName;
    private List<Book> borrowedBooks;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        borrowedBooks = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        System.out.println(firstName + " " + lastName + " borrowed \"" + book.getTitle() + "\".");
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        System.out.println(firstName + " " + lastName + " returned \"" + book.getTitle() + "\".");
    }

    public void displayUserInfo() {
        System.out.println("User: " + firstName + " " + lastName);
        System.out.println("Borrowed books: ");
        for (Book book : borrowedBooks) {
            book.displayInfo();
        }
    }
}
