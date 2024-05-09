package CRUD;

import Class.Book;
import Class.Customer;

public class CartCRUD {
    private final BookCRUD bookCRUD;
    private final Customer customer;

    public CartCRUD(BookCRUD bookCRUD, Customer customer) {
        this.bookCRUD = bookCRUD;
        this.customer = customer;
    }

    // View Cart
    public void viewCart() {
        System.out.println("Book list:");
        for (int i = 0; i < customer.getCart().getBooks().size(); i++) {
            System.out.println(customer.getCart().getBooks().get(i));
        }
        System.out.print("Total Price: ");
        System.out.println(calculatorTotalPrice());
        System.out.println("Thank you used service");
    }

    public void addBookToCart(int bookID, int quantity) {
        boolean bookFound = false;
        for (int i = 0; i < bookCRUD.getPendingBook().size(); i++) {
            Book book = bookCRUD.getPendingBook().get(i);
            if (book.getBookId() == bookID) {
                // Thêm cuốn sách vào giỏ hàng và số lượng sách trong Lits được chỉ định
                System.out.println("Book with ID: " + bookID + "." );
                book.setQuantity(quantity);
                System.out.println("Has been added to cart with quantity: " + quantity + ".");
                bookFound = true;
                // Cập nhật số lượng sách trong giỏ hàng
                customer.getCart().addBooks(book);
                System.out.println("Add to cart successfully.");
                System.out.println("Thank You Use Service.");
                break;
            }
        }
        if (!bookFound) {
            System.out.println("Book with ID " + bookID + " not found.");
            System.out.println("Please input Book id try again.");
        }
    }
    public void deleteCart(int bookID) {
        boolean bookFound = false;
        for (int i = 0; i < customer.getCart().getBooks().size(); i++) {
            Book book = customer.getCart().getBooks().get(i);
            if (book.getBookId() == bookID) {
                customer.getCart().getBooks().remove(i);
                System.out.println("Book with ID " + bookID + " has been removed from cart.");
                bookFound = true;
                break;
            }
        }
        if (!bookFound) {
            System.out.println("Book with ID " + bookID + " not found in cart.");
        }
    }

    public double calculatorTotalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < customer.getCart().getBooks().size(); i++) {
            totalPrice += customer.getCart().getBooks().get(i).getPrice();
        }
        return totalPrice;
    }
}