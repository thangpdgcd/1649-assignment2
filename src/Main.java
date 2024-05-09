import CRUD.BookCRUD;
import CRUD.CartCRUD;
import CRUD.OrderManagerCRUD;
import CRUD.OrderUserCRUD;
import Class.Customer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(12, "Phan Thang", "0372713679", "Kon Tum");
        Scanner sc = new Scanner(System.in);
        BookCRUD bookCRUD = new BookCRUD();
        CartCRUD cartCRUD = new CartCRUD(bookCRUD, customer);
        bookCRUD.addBook("Horor", "Phan Thang Phan", 12.2, 13);
        bookCRUD.addBook("Funny", "Bui Quoc Hung", 27.1, 7);
        bookCRUD.addBook("Action", "Nguyen Trong Hoang Anh", 2.4, 9);
        bookCRUD.addBook("Romatic", "Tran Duc Linh", 11.2, 7);
        bookCRUD.addBook("Mavel", "John Wick", 7.8, 9);
        bookCRUD.addBook("Kong and Godzilla", "Cristiano Ronaldo", 3.5, 12);
        bookCRUD.addBook("Doctor Strange", "Lionel Messi", 7.9, 5);
        bookCRUD.addBook("Cartoon", "Neymar JR", 1.2, 8);
        bookCRUD.addBook("Spiderman", "Toni Kroos", 6.7, 13);
        bookCRUD.addBook("Superman", "Hary Kane", 8.9, 22);
        OrderUserCRUD orderUserCRUD = new OrderUserCRUD();
        OrderManagerCRUD orderManagerCRUD = new OrderManagerCRUD();
        int choice = 0;
        do {
            System.out.println("\n|----------------------|");
            System.out.println("| Welcome To BookStore |");
            System.out.println("| 1. User              |");
            System.out.println("| 2. Manager           |");
            System.out.println("| 3. Exit              |");
            System.out.println("|______________________|\n");
            System.out.println("\nEnter your choice: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    int userChoice;
                    do {
                        System.out.println("\n|------------------|");
                        System.out.println("|   User Menu      |");
                        System.out.println("| 1. View Book     |");
                        System.out.println("| 2. Cart          |");
                        System.out.println("| 3. Search Book   |");
                        System.out.println("| 4. Checkout      |");
                        System.out.println("| 5. Sort a->z     |");
                        System.out.println("| 6. Exit          |");
                        System.out.println("|__________________|\n");
                        System.out.println("\nEnter your choice: ");
                        userChoice = Integer.parseInt(sc.nextLine());
                        switch (userChoice) {
                            case 1:
                                bookCRUD.ViewBook();
                                break;
                            case 2:
                                int choicecart;
                                do {
                                    System.out.println("\n|--------------------|");
                                    System.out.println("|     Menu Cart      |");
                                    System.out.println("| 1. Add New Cart    |");
                                    System.out.println("| 2. View All Cart   |");
                                    System.out.println("| 3. Delete Cart     |");
                                    System.out.println("| 4. Exit            |");
                                    System.out.println("|____________________|\n");
                                    System.out.println("\nEnter your choice: ");
                                    choicecart = Integer.parseInt(sc.nextLine());
                                    switch (choicecart) {
                                        case 1:
                                            System.out.println("Enter the BookId of the book you want to add to cart: ");
                                            int booktocartId = Integer.parseInt(sc.nextLine());
                                            System.out.println("Enter Quantity: ");
                                            int quantity =Integer.parseInt(sc.nextLine());
                                            cartCRUD.addBookToCart(booktocartId,quantity);
                                            break;
                                        case 2:
                                            cartCRUD.viewCart();
                                            break;
                                        case 3:
                                            System.out.print("Enter a Cart need to delete the cart from cart:  ");
                                            int cartid = Integer.parseInt(sc.nextLine());
                                            cartCRUD.deleteCart(cartid);
                                            System.out.println("Delete successfully!");
                                            break;
                                        case 4:
                                            System.out.println("Exit Menu Cart ");
                                            break;
                                        default:
                                            System.out.println("Invalid choice");
                                            break;
                                    }
                                } while (choicecart != 4);
                                break;
                            case 3:
                                System.out.println("Do you want Search Book? ");
                                System.out.println("You Can Enter Input Search Book: ");
                                String searchBook = sc.nextLine();
                                bookCRUD.searchBookByTitle(searchBook);
                                System.out.println("Search Book successfully");
                                break;
                            case 4:
                                int choiceorder;
                                do {
                                    System.out.println("\n|------------------------|");
                                    System.out.println("|    Menu User           |");
                                    System.out.println("| 1. View Order          |");
                                    System.out.println("| 2. Create Order        |");
                                    System.out.println("| 3. Exit                |");
                                    System.out.println("|________________________|\n");
                                    System.out.println("\nEnter your choice: ");
                                    choiceorder = Integer.parseInt(sc.nextLine());
                                    switch (choiceorder) {
                                        case 1:
                                            orderUserCRUD.ViewOrderUser(customer);
                                            break;
                                        case 2:
                                            System.out.println("Enter input Address: ");
                                            String address = sc.nextLine();
                                            System.out.println("Enter input Email: ");
                                            String email = sc.nextLine();
                                            orderUserCRUD.AddOrderUser(customer, email, address, customer.getCart().getBooks(), orderManagerCRUD);
                                            //customer lay cuon sach trong cai cart customer
                                            break;
                                        case 3:
                                            System.out.println("Exit Menu Order");
                                            break;
                                        default:
                                            System.out.println("Error: Invalid choice");
                                            break;
                                    }
                                } while (choiceorder != 3);
                                break;
                            case 5:
                                System.out.println("List Sort");
                                //sau khi chon option nay no se tu sort lai list book
                                bookCRUD.sortBookAZ();
                                break;
                            case 6:
                                System.out.println(" Exit Menu User");
                                break;
                            default:
                                System.out.println("Error: Invalid choice");
                                break;
                        }
                    } while (userChoice != 6);
                    break;
                case 2:
                    //menu manager
                    int adminChoice;
                    do {
                        System.out.println("\n|------------------------|");
                        System.out.println("|    Manager Menu        |");
                        System.out.println("| 1. View Book           |");
                        System.out.println("| 2. Create Book         |");
                        System.out.println("| 3. Edit Book           |");
                        System.out.println("| 4. Delete Book         |");
                        System.out.println("| 5. Order Manager       |");
                        System.out.println("| 6. Sort A->Z           |");
                        System.out.println("| 7. Exit                |");
                        System.out.println("|________________________|\n");
                        System.out.println("\nEnter your choice: ");
                        adminChoice = Integer.parseInt(sc.nextLine());
                        switch (adminChoice) {
                            case 1:
                                /*View Book*/
                                bookCRUD.ViewBook();
                                break;
                            case 2:
                                /*Create Book start*/
                                System.out.print("Enter input Title: ");
                                String title = sc.nextLine();
                                System.out.print("Enter input Author: ");
                                String author = sc.nextLine();
                                System.out.print("Enter input Price: ");
                                Double price = (Double) Double.parseDouble(sc.nextLine());
                                System.out.println("Enter input Quantity: ");
                                int quantity = Integer.parseInt(sc.nextLine());
                                bookCRUD.addBook(title, author, price, quantity);
                                System.out.println("Create Books successfully!");
                                break;
                            /*End Create Book*/
                            case 3:
                                /*updatebook
                                 * start*/
                                System.out.println("Enter BookId Update");
                                int bookID = Integer.parseInt(sc.nextLine());
                                System.out.print("Enter input Title Update: ");
                                String titles = sc.nextLine();
                                System.out.print("Enter input Author Update: ");
                                String authors = sc.nextLine();
                                System.out.print("Enter input Price Update: ");
                                Double prices = (Double) Double.parseDouble(sc.nextLine());
                                System.out.println("Enter input Quantity Update: ");
                                int quantitys = Integer.parseInt(sc.nextLine());
                                bookCRUD.updateBook(bookID, titles, authors, prices, quantitys);
                                System.out.println("Update successfully!");
                                break;
                            /*end updatebook*/
                            case 4:
                                /*Deletebook Start*/
                                System.out.print("Enter a BookId to Delete: ");
                                int bookid = Integer.parseInt(sc.nextLine());
                                bookCRUD.deleteBook(bookid);
                                System.out.println("Delete successfully!");
                                break;
                            /*Deletebook end*/
                            case 5:
                                int choiceOrderManager;
                                do {
                                    System.out.println("\n|------------------------|");
                                    System.out.println("|   Menu Manager         |");
                                    System.out.println("| 1. View Order          |");
                                    System.out.println("| 2. Delete Order        |");
                                    System.out.println("| 3. Search Order        |");
                                    System.out.println("| 4. Process Order       |");
                                    System.out.println("| 5. Sort Order A-> Z    |");
                                    System.out.println("| 6. Exit                |");
                                    System.out.println("|________________________|\n");
                                    System.out.println("\nEnter your choice: ");
                                    choiceOrderManager = Integer.parseInt(sc.nextLine());
                                    switch (choiceOrderManager) {
                                        case 1:
                                            //view
                                            orderManagerCRUD.ViewOrderManager(customer);

                                            break;
                                        case 2:
                                            //delete
                                            System.out.println("Enter the Order You want to Delete:  ");
                                            int orderid = Integer.parseInt(sc.nextLine());
                                            orderManagerCRUD.DeleteOrderManager(orderid);
                                            break;
                                        case 3:
                                            //search
                                            System.out.println("Do you want search order");
                                            String Email = sc.nextLine();
                                            orderManagerCRUD.searchOrderManagerByEmail(Email);
                                            break;
                                        case 4:
                                            System.out.println("Input Id Need Accept");
                                            int orderID = Integer.parseInt(sc.nextLine());

                                            orderManagerCRUD.process(orderID);
                                            break;
                                        case 5:
                                            System.out.println("list sort");
                                            orderManagerCRUD.sortOrder();
                                            break;
                                        case 6:
                                            System.out.println("Exit");
                                            break;
                                        default:
                                            System.out.println("Invalid Choice");
                                            break;
                                    }
                                } while (choiceOrderManager != 6);
                            case 6:
                                //sau khi chon option nay no se tu sort lai list book
                                bookCRUD.sortBookAZ();
                                break;
                            case 7:
                                System.out.println("Exit");
                                break;
                            default:
                                System.out.println("Error: Invalid choice");
                                break;
                        }
                    } while (adminChoice != 7);
                    break;
                case 3:
                    System.out.println("Exit Program.....");
                    break;
                default:
                    System.out.println("Error: Invalid choice");
                    break;
            }
        } while (choice != 3);
    }
}