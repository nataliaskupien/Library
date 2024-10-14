package models;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println(book.getTitle() + " has been added to the library");
    }

    public void removeBook(Book book) {
        books.remove(book);
        System.out.println(book.getTitle() + " has been removed from the library");
    }

    public void registerUser(User user) {
        users.add(user);
        System.out.println("Registered new user: " + user.getFirstName() + " " + user.getLastName());
    }

    public void borrowBook(User user, Book book) {
        if (books.contains(book)) {
            if (book.getQuantity() > 0) {
                user.borrowBook(book);
                book.changeAvailableQuantity(book, false);
            } else {
                System.out.println("Book: " + book.getTitle() + " is not available");
            }
        }
    }
    public void returnBook(User user, Book book) {
        if(!user.getBorrowedBooks().isEmpty()) {
            book.changeAvailableQuantity(book, true);
            user.returnBook(book);
        } else {
            System.out.println(user.getFirstName() + " " + user.getLastName() + " didn't borrow " +
                    book.getTitle() + " yet");
        }
    }

    public void displayAvailableBooks() {
        for (Book book : books) {
            book.displayInfo();
        }
    }
}
