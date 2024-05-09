package CRUD;

import Class.Book;
import Class.Customer;
import Class.Order;
import function.ArrayList;
import function.Queue;

public class OrderUserCRUD {
    private final Queue<Order> pendingorders;
    private final Queue<Order> completedorders;
    private int Orderid;

    public OrderUserCRUD() {
        this.pendingorders = new Queue<>();
        this.completedorders = new Queue<>();
        this.Orderid = 1;
    }

    public void AddOrderUser(Customer customer, String email, String address, ArrayList<Book> books, OrderManagerCRUD orderManagerCRUD) {
        Order order = new Order(Orderid, address, email, books);
        if (order != null) {
            this.pendingorders.offer(order);
            System.out.println("Add new Order");
            customer.addOrder(order);
            orderManagerCRUD.addOrder(order);//de list cua orderuser trung voi ordermanager
            Orderid++;
        }
    }


    public void ViewOrderUser(Customer customer) {
        System.out.println("Order list:");
        ArrayList<Order> orders = customer.getOrder().toList();
        for (int i = 0; i < orders.size(); i++) {
            System.out.println("Order ID: " + orders.get(i).getOrderid() +
                    ", Status: " + orders.get(i).getStatus() +
                    ", Email: " + orders.get(i).getEmail() +
                    ", Address: " + orders.get(i).address() +
                    ", Price: " + orders.get(i).calculatorOrder());
        }
    }




}
