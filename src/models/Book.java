package models;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int quantity;

    public Book(String title, String author, String isbn, int quantity) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getQuantity() {
        return quantity;
    }

    public void changeAvailableQuantity(Book book, boolean increase){
        if (quantity >= 0 && increase) {
            quantity++;
        }
        else if (quantity > 0 && !increase) {
            quantity--;
        }
    }

    public void displayInfo() {
        System.out.println("-".repeat(30));
        System.out.println("Title: " + title + "\nAuthor: " + author + "\nISBN: " + isbn + "\nQuantity: " + quantity);
    }
}
