package object;

import java.util.HashMap;

public class Invoice {

    private String invoiceID;
    private String customerID;
    private final HashMap<String, Integer> item = new HashMap<>();
    private double total;

    public Invoice(String invoiceID, String customerID, String iceId, int amount) {
        this.invoiceID = invoiceID;
        this.customerID = customerID;
        this.item.put(iceId, amount);

    }

    public Invoice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public HashMap<String, Integer> getItem() {
        return item;
    }

    public void addItem(String iceId, int amount) {
        this.item.put(iceId, amount);
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String printItem() {
        int value;
        StringBuilder sb = new StringBuilder();
        for (String key : item.keySet()) {
            value = item.get(key);
            sb.append("[").append(key).append(", ").append(value).append("]; ");
        }
        return sb.toString();
    }

    public void printInvoice() {
        System.out.print("[ " + invoiceID + ", " + customerID + ", " + this.printItem() + ", " + total + " ]");
    }

}
