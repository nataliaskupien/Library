package models;

public class Nature extends Book{
    private String category;

    public Nature(String title, String author, String isbn, int quantity, String category) {
        super(title, author, isbn, quantity);
        this.category = category;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Subject: " + category);
        System.out.println("-".repeat(30));
    }
}
