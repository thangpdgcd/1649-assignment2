package Class;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private double price;
    private int quantity;

    public Book(int bookId, String title, String author, double price, int quantity) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "|___________________________________/\n" +
                "|  BookId:   " + bookId + "                     /\n" +
                "|  Title:    " + title + "                /\n" +
                "|  Author:   " + author + "                /\n" +
                "|  Price:    " + price + "                /\n" +
                "|  Quantity: " + quantity + "                  /\n" +
                "|_________________________________/\n";
    }


}