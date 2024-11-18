package object;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import manage.Manager;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hanh
 */
public final class Invoice {
    private String invoiceID;
    private String customerID;
    private final HashMap<String, Integer> item = new HashMap<>();
    private double total;
    

    public Invoice(String invoiceID, String customerID, String iceId, int amount) {
        this.invoiceID = invoiceID;
        this.customerID = customerID;
        this.item.put(iceId, amount);
        
    }

    public HashMap<String, Integer> getItem() {
        return item;
    }
    
    public void addItem(String iceId, int amount){
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
    public void printInvoice(){
        System.out.println("[ "+invoiceID+", "+customerID+", "+item.toString()+ ", "+total );
    }

    
    
}
