import models.*;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        library.addBook(new Historical("History of Selborne", "Gilbert White", "978-3-16-148410-0",
                2,"Historical" ));
        library.addBook(new Historical("1984", "George Orwell", "978-0-306-40615-7",
                1, "Historical"));
        library.addBook(new Nature("Wild", "Cheryl Strayed", " 978-1-4028-9462-6",
                4, "Nature"));
        library.addBook(new Nature("The Soul of an Octopus", " Sy Montgomery", " 978-0-12-374856-0",
                2, "Nature"));
        library.addBook(new ScienceFiction("Dune", "Frank Herbert", "978-1-60309-027-0",
                5, "Science Fiction"));
        library.addBook(new ScienceFiction("The Alchemist", "Paulo Coelho", "978-1-60309-027-0",
                5, "Science Fiction"));

        User user1 = new User("John", "Doe");
        library.registerUser(user1);

        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to the Library Menu");
            System.out.println("1. Display available books");
            System.out.println("2. Borrow book");
            System.out.println("3. Return book");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    library.displayAvailableBooks();
                    System.out.println("If you want to filter books by category insert: " +
                                    "Nature, Historical or ScienceFiction :");
                    scanner.nextLine();
                    String category = scanner.nextLine();
                    if (category.equals("Nature")) {
                        List<Book> sorted = library.getNatureBooks(category);
                        for (Book book : sorted) {
                            book.displayInfo();
                        }
                    }
                }
                case 2 -> {
                    System.out.print("Enter book title to borrow: ");
                    scanner.nextLine();
                    String borrowTitle = scanner.nextLine();
                    for (Book book : library.getBooks()) {
                        if (book.getTitle().equalsIgnoreCase(borrowTitle)) {
                            library.borrowBook(user1, book);
                        }
                    }
                }
                case 3 -> {
                    System.out.print("Enter book title to return: ");
                    scanner.nextLine();
                    String returnTitle = scanner.nextLine();
                    for (Book book : library.getBooks()) {
                        if (book.getTitle().equalsIgnoreCase(returnTitle)) {
                            library.returnBook(user1, book);
                        }
                    }
                }
                case 4 -> {
                    running = false;
                    System.out.println("Exiting the library system. Goodbye!");
                }
                default -> System.out.println("Invalid option please try again.");
            }
        }
        scanner.close();
    }
}