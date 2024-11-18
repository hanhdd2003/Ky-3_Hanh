/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import object.Customer;
import object.IceCream;
import object.Invoice;
import validated.Validate;

/**
 *
 * @author Hanh
 */
public class Manager {

    private final List<IceCream> listIceCream = new ArrayList<>();
    private final List<Invoice> listInvoice = new ArrayList<>();
    private final List<Customer> listCustomer = new ArrayList<>();
    private final Validate val = new Validate();

    public Manager() {
    }

    public List<IceCream> getListIceCream() {
        return listIceCream;
    }

    public List<Invoice> getListInvoice() {
        return listInvoice;
    }

    public List<Customer> getListCustomer() {
        return listCustomer;
    }

    public void addIceCream() {
        String iceID = val.inString("Enter id: ");
        String name = val.inString("Enter Name: ");
        String type = val.inString("Enter type: ");
        double price = val.inDouble("Enter price: ");
        IceCream ice = new IceCream(iceID, name, type, price);
        if (checkIceID(ice.getIceID()) == null) {
            listIceCream.add(ice);
        } else {
            System.out.println("IceCream already exist");
        }
    }

    public void addCustomer() {
        String customerID = val.inString("Enter ID: ");
        String name = val.inString("Enter name: ");
        String phoneNumber = val.inPhone();
        Customer cus = new Customer(customerID, name, phoneNumber);
        if (this.checkCustomer(customerID) == null) {
            listCustomer.add(cus);
        } else {
            System.out.println("Customer already exist");
        }
    }

    public void addInvoice() {
        String invoiceID = val.inString("Enter Invoice ID: ");
        String customerID = val.inString("Enter customer ID: ");
        String iceID = val.inString("Enter ice ID: ");
        int amount = val.inInt("Enter amount: ");
        IceCream iceCream = this.checkIceID(iceID);
        //nếu không có kem thì thoát
        if (iceCream == null) {
            return;
        }
        // nếu không có khách hàng trong danh sách thì thêm vào
        if (this.checkCustomer(customerID) == null) {
            this.addCustomer();
        }
        //kiểm tra đơn hàng nếu có thì cập nhật lại 
        Invoice existingInvoice = this.checkInvoice(invoiceID);
        if (existingInvoice != null && this.checkIdInvoiceAndIDCus(invoiceID, customerID)) {
            HashMap<String, Integer> item = existingInvoice.getItem();
            if (item.containsKey(iceID)) {
                int value = item.get(iceID) + amount;
                item.put(iceID, value);
                existingInvoice.setTotal(iceCream.getPrice() * value);
            } else {
                item.put(iceID, amount);
                existingInvoice.setTotal(existingInvoice.getTotal() + iceCream.getPrice() * amount);
            }
        } else {
            // If the invoice doesn't exist, create a new one
            Invoice invoice = new Invoice(invoiceID, customerID, iceID, amount);
            invoice.setTotal(iceCream.getPrice() * amount);
            listInvoice.add(invoice);
        }
    }

    public void addItem() {
        String invoidID = val.inString("Enter invoice ID: ");
        Invoice invoice = this.checkInvoice(invoidID);
        if (invoice == null) {
            return;
        }
        String iceID = val.inString("Enter ice ID: ");
        IceCream ice = this.checkIceID(iceID);
        if (ice == null) {
            return;
        }
        int amount = val.inInt("Enter amount: ");
        invoice.getItem().put(iceID, amount);
        invoice.setTotal(invoice.getTotal() + this.checkIceID(iceID).getPrice()*amount);
        

    }

    public boolean checkIdInvoiceAndIDCus(String idInvoice, String cusID) {
        for (Invoice inv : listInvoice) {
            if (inv.getInvoiceID().equalsIgnoreCase(idInvoice) && inv.getCustomerID().equalsIgnoreCase(cusID)) {
                return true;
            }
        }
        return false;
    }

    public Invoice checkInvoice(String id) {
        for (Invoice invoice : listInvoice) {
            if (invoice.getInvoiceID().equalsIgnoreCase(id)) {
                return invoice;
            }
        }
        return null;
    }

    public Customer checkCustomer(String id) {
        for (Customer cus : listCustomer) {
            if (cus.getCustomerID().equalsIgnoreCase(id)) {
                return cus;
            }
        }
        return null;
    }

    public IceCream checkIceID(String id) {
        for (IceCream ice : listIceCream) {
            if (ice.getIceID().equalsIgnoreCase(id)) {
                return ice;
            }
        }
        return null;
    }
}
