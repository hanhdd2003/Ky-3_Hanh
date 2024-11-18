package Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import object.Customer;
import object.IceCream;
import object.Invoice;
import validated.Validate;

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
        String iceID = val.inputString("Enter id: ");
        if (checkIceID(iceID) != null) {
            System.out.println("IceCream already exists");
            return;
        }

        String name = val.inputString("Enter Name: ");
        String type = val.inputString("Enter type: ");
        double price = val.inputDouble("Enter price: ");
        IceCream ice = new IceCream(iceID, name, type, price);
        listIceCream.add(ice);
    }

    public void addCustomer() {
        String customerID = val.inputString("Enter ID: ");
        if (checkCustomer(customerID) != null) {
            System.out.println("Customer already exists");
            return;
        }

        String name = val.inputString("Enter name: ");
        String phoneNumber = val.inputPhone();
        Customer cus = new Customer(customerID, name, phoneNumber);
        listCustomer.add(cus);
    }

    public void addInvoice() {
        String invoiceID = val.inputString("Enter Invoice ID: ");
        String customerID = val.inputString("Enter customer ID: ");
        String iceID = val.inputString("Enter ice ID: ");
        int amount = val.inputInt("Enter amount: ");

        IceCream iceCream = checkIceID(iceID);
        if (iceCream == null) {
            return;
        }

        Customer customer = checkCustomer(customerID);
        if (customer == null) {
            addCustomer();
            customer = checkCustomer(customerID);
        }

        Invoice existingInvoice = checkInvoice(invoiceID);
        if (existingInvoice != null && checkIdInvoiceAndIDCus(invoiceID, customerID)) {
            HashMap<String, Integer> item = existingInvoice.getItem();
            item.merge(iceID, amount, Integer::sum);
            existingInvoice.setTotal(iceCream.getPrice() * item.get(iceID));
        } else {
            Invoice invoice = new Invoice(invoiceID, customerID, iceID, amount);
            invoice.setTotal(iceCream.getPrice() * amount);
            listInvoice.add(invoice);
        }
    }

    public void addItem() {
        String invoiceID = val.inputString("Enter invoice ID: ");
        Invoice invoice = checkInvoice(invoiceID);
        if (invoice == null) {
            return;
        }

        String iceID = val.inputString("Enter ice ID: ");
        IceCream ice = checkIceID(iceID);
        if (ice == null) {
            return;
        }

        int amount = val.inputInt("Enter amount: ");
        invoice.getItem().merge(iceID, amount, Integer::sum);
        invoice.setTotal(ice.getPrice() * invoice.getItem().get(iceID));
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
        for (Invoice inv : listInvoice) {
            if (inv.getInvoiceID().equalsIgnoreCase(id)) {
                return inv;
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
