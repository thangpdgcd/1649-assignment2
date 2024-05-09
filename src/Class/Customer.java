package Class;

import function.Queue;

public class Customer {

    private final String fullname;
    private final String phonenumber;
    private final String address;
    private final Cart cart;
    private final Queue<Order> orders;
    private int customerID;

    public Customer(int customerID, String fullname, String phonenumber, String address) {
        this.customerID = customerID;
        this.fullname = fullname;
        this.phonenumber = phonenumber;
        this.address = address;
        this.cart = new Cart();
        this.orders = new Queue<>();
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getFullnam() {
        return fullname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public Cart getCart() {
        return cart;
    }

    public Queue<Order> getOrder() {
        return orders;
    }

    public void addOrder(Order order) {
        try {
            if (!this.orders.isEmpty()) {
                Order oldHead = orders.peek();
                oldHead.setStatus("shipping");
            }
            this.orders.offer(order);
            order.setStatus("pending");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public String toString() {
        return "|___________________________________/\n" +
                "| ID:" + customerID + "                     /\n" +
                "| fullname='" + fullname + "                /\n" +
                "| phonenumber='" + phonenumber + "                /\n" +
                "| address='" + address + "                /\n" +
                "|_________________________________/\n";
    }
}

