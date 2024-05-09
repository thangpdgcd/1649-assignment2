package Class;

import function.ArrayList;

public class Order {
    private int orderid;
    private String status;
    private String address;
    private String email;
    private ArrayList<Book> books;


    public Order(int orderid, String address, String email, ArrayList<Book> books) {
        this.orderid = orderid;
        this.status = "pending";
        this.address = address;
        this.email = email;
        this.books = books;
    }

    public Order() {

    }


    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String address() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double calculatorOrder() {
        double totalPrice = 0;
        for (int i = 0; i < books.size(); i++) {
            totalPrice += books.get(i).getPrice();
        }
        return totalPrice;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("|___________________________________/\n");
        sb.append("| Order ID: ").append(orderid).append("                     /\n");
        sb.append("| Status: ").append(status).append("                     /\n");
        sb.append("| Email: ").append(email).append("                     /\n");
        sb.append("| Order address: ").append(address).append("                     /\n");
        sb.append("| Books:\n");
        for (int i = 0; i < books.size(); i++) {
            sb.append("|   ").append(books.get(i).toString()).append("\n");
        }
        sb.append("|_________________________________/\n");
        return sb.toString();
    }
}