package CRUD;

import Class.Book;
import function.ArrayList;

public class BookCRUD {
    private final ArrayList<Book> pendingbook;

    private int bookId = 1;

    public BookCRUD() {
        pendingbook = new ArrayList<>();

    }

    public void addBook(String title, String author, double price, int quantity) {
        Book book = new Book(bookId, title, author, price, quantity);
        pendingbook.add(book);
        bookId++;
    }

    public void updateBook(int bookId, String title, String author, double price, int quantity) {
        boolean bookFound = false;
        for (int i = 0; i < pendingbook.size(); i++) {
            Book book = pendingbook.get(i);
            if (book.getBookId() == bookId) {
                // Update the book's information
                book.setTitle(title);
                book.setAuthor(author);
                book.setPrice(price);
                book.setQuantity(quantity);
                bookFound = true;
                System.out.println("Book with ID " + bookId + " has been updated.");
                break;
            }
        }
        if (!bookFound) {
            System.out.println("Book with ID " + bookId + " does not exist.");
        }
    }

    public void ViewBook() {
        System.out.println("Book list:");
        for (int i = 0; i < pendingbook.size(); i++) {
            Book book = pendingbook.get(i);
            System.out.println(book);
        }

    }

    public void deleteBook(int bookID) {
        boolean BookFound = false;
        for (int i = 0; i < pendingbook.size(); i++) {
            Book book = pendingbook.get(i);
            if (book.getBookId() == bookID) {
                pendingbook.remove(i);
                BookFound = true;
                System.out.println("Customer " + bookID + " has been deleted.");
                break;
            }
        }
        if (!BookFound) {
            System.out.println("Customer " + bookID + " does not exist.");
        }
    }

    public void searchBookByTitle(String title) {
        boolean bookFound = false;
        System.out.println("Search results for title: " + title);
        for (int i = 0; i < pendingbook.size(); i++) {
            if (pendingbook.get(i).getTitle().toLowerCase().contains(title.toLowerCase())) {
                //constain (if(title in book tuong dong String title)
                // no se  search book)
                Book book = pendingbook.get(i);
                System.out.println("You Was Result Search title" + book);
                bookFound = true;
            }
        }
        if (!bookFound) {
            System.out.println("No books found with the title containing: " + title);
        }
    }

    public ArrayList<Book> getPendingBook() {
        return pendingbook;
    }

    //xap xep
    public void sortBookAZ() {//Bubble Sort
        int n = pendingbook.size(); /// gán bằng kích thước danh sách book
        for (int i = 0; i < n - 1; i++) {
            //Đây là một vòng lặp ngoài để duyệt qua từng phần tử trong danh sách, trừ phần tử cuối cùng.
            for (int j = i + 1; j < n; j++) {
                Book book1 = pendingbook.get(i);
                //Lấy sách tại vị trí i trong danh sách pendingbook và gán vào biến book1.
                Book book2 = pendingbook.get(j);
                // Lấy sách tại vị trí j trong danh sách pendingbook và gán vào biến book2.
                if (book1.getTitle().compareTo(book2.getTitle()) > 0) {
                    // Swap books if they are out of order
                    pendingbook.set(i, book2);
                    pendingbook.set(j, book1);
                    //Nếu điều kiện trên đúng, hai sách sẽ được hoán đổi chỗ với nhau. Sách book2 sẽ được đặt ở vị trí i.
                    //Sách book1 sẽ được đặt ở vị trí j, hoàn thành việc hoán đổi chỗ.
                }
            }
        }
        System.out.println("List was Sorting");
        for (int i = 0; i < pendingbook.size(); i++) {
            Book book = pendingbook.get(i);
            System.out.println(book);
        }

    }
}