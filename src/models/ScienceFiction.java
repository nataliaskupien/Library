package models;

public class ScienceFiction extends Book{
    private String category;

    public ScienceFiction(String title, String author, String isbn, int quantity, String category) {
        super(title, author, isbn, quantity);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Subject: " + category);
        System.out.println("-".repeat(30));
    }
}
