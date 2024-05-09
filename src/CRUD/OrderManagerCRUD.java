package CRUD;

import Class.Customer;
import Class.Order;
import function.ArrayList;
import function.Queue;

import java.util.Scanner;

public class OrderManagerCRUD {
    private final Queue<Order> pendingorders;
    private final Queue<Order> completedorders;
    private final int Orderid;

    public OrderManagerCRUD() {
        this.pendingorders = new Queue<>();
        this.completedorders = new Queue<>();
        this.Orderid = 1;
    }


    public void ViewOrderManager(Customer customer) {
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


    public void DeleteOrderManager(int orderid) {
        try {
            boolean orderFound = false;
            Queue<Order> DeleteQueue = new Queue<>();
            while (!pendingorders.isEmpty()) {
                Order order = pendingorders.poll();
                if (order.getOrderid() == orderid) {
                    orderFound = true;
                    System.out.println("Order " + orderid + " has been deleted.");
                    System.out.println("Delete Order successfully");
                } else {
                    DeleteQueue.offer(order);
                }
            }
            if (!orderFound) {
                System.out.println("Order " + orderid + " does not exist.");
                System.out.println("Please try again");
            }
            // Thêm lại các phần tử từ hàng đợi tạm thời vào hàng đợi gốc
            while (!DeleteQueue.isEmpty()) {
                pendingorders.offer(DeleteQueue.poll());
            }
        } catch (Exception error) {
            System.out.println("Error" + error);
        }
    }


    public void sortOrder() {//Bubble Sort
        int n = pendingorders.size();
        for (int i = 0; i < n - 1; i++) {
            // Duyệt qua từng phần tử trong danh sách
            for (int j = 0; j < n - i - 1; j++) {
                // So sánh trạng thái của hai đơn hàng liên tiếp
                Order order1 = pendingorders.toList().get(j);
                Order order2 = pendingorders.toList().get(j + 1);
                // Nếu trạng thái của order1 lớn hơn order2, hoán đổi vị trí
                if (order1.getStatus().compareTo(order2.getStatus()) > 0) {
                    // Swap orders
                    pendingorders.poll();
                    pendingorders.offer(order2);
                    pendingorders.offer(order1);
                }
            }
        }
        System.out.println("List was Sorting");
        for (int i = 0; i < pendingorders.size(); i++) {
            Order order = pendingorders.toList().get(i);
            System.out.println(order);
        }
    }

    public void searchOrderManagerByEmail(String email) {
        boolean orderFound = false;
        System.out.println("Search results for email: " + email);
        for (int i = 0; i < pendingorders.size(); i++) {
            if (pendingorders.toList().get(i).getEmail().equalsIgnoreCase(email)) {
                Order order = pendingorders.toList().get(i);
                System.out.println("Order found: " + order);
                orderFound = true;
            }
        }
        if (!orderFound) {
            System.out.println("No orders found with the email: " + email);
        }
    }
    public void process(int orderID) {
        Scanner sc=new Scanner(System.in);
        boolean orderFound=false;
        int choiceprocess;
        do {
            System.out.println("\n|--------------------|");
            System.out.println("|    Manager Accept   |");
            System.out.println("|  1. Approve         |");
            System.out.println("|  2. Reject          |");
            System.out.println("|  3. Exit            |");
            System.out.println("|_____________________|\n");
            System.out.println("Enter your choice: ");
            choiceprocess = Integer.parseInt(sc.nextLine());
            switch (choiceprocess) {
                case 1:
                    System.out.println("Approving Order");
                    for (int i = 0; i < pendingorders.size(); i++) {
                        if (pendingorders.toList().get(i).getOrderid() == orderID) {
                            Order order = pendingorders.toList().get(i);
                            // Thay đổi trạng thái đơn hàng thành "Shipping"
                            order.setStatus("Shipping");
                            completedorders.offer(order);
                            System.out.println("Order " + orderID + " has been approved and processed.");
                            orderFound = true;
                            break;
                        }
                    }
                    if (!orderFound) {
                        System.out.println("Order " + orderID + " not found in pending orders.");
                    }
                    break;
                case 2:
                    System.out.println("Rejecting Order");
                    for (int i = 0; i < pendingorders.size(); i++) {
                        if (pendingorders.toList().get(i).getOrderid() == orderID) {
                            Order order = pendingorders.poll();
                            order.setStatus("Pending");
                            System.out.println("Order " + orderID + " has been rejected and status set " +
                                    "to Pending.");
                            orderFound = true;
                            break;
                        }
                    }
                    if (!orderFound) {
                        System.out.println("Order " + orderID + " not found in pending orders.");
                    }

                case 3:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choiceprocess != 3);
    }
    public void addOrder(Order order) {
        this.pendingorders.offer(order);
    }

}

