
package Class;

import function.ArrayList;

public class Cart {
    private final ArrayList<Book> books;

    public Cart(ArrayList<Book> books) {
        this.books = books;
    }
    public Cart() {
        books = new ArrayList();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBooks(Book book) {
        books.add(book);
    }

}