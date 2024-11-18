package Manager;


import avltree.InvoiceAVLTree;
import object.Customer;
import object.IceCream;
import object.Invoice;

public class Main {

    public static void main(String[] args) {
        InvoiceAVLTree invoiceTree = new InvoiceAVLTree();

        IceCream mintChip = new IceCream("I001", "Mint Chip", "Regular", 2.5);
        IceCream cookiesNCream = new IceCream("I002", "Cookies 'n Cream", "Regular", 2.8);
        IceCream rockyRoad = new IceCream("I003", "Rocky Road", "Premium", 3.5);

        Customer hoang = new Customer("C001", "Hoang", "0987123567");
        Customer linh = new Customer("C002", "Linh", "0976472842");

        // Task 1: Create an invoice for a customer who uses the service
        Invoice inv001 = new Invoice("INV001", hoang.getCustomerID(), mintChip.getIceID(), 7);
        inv001.setTotal(mintChip.getPrice()*7);
        Invoice inv002 = new Invoice("INV002", linh.getCustomerID(), cookiesNCream.getIceID(), 5);
        inv002.setTotal(cookiesNCream.getPrice()*5);

        // Add the invoices to the AVL tree
        invoiceTree.addInvoice(inv001);
        invoiceTree.addInvoice(inv002);

        // Task 2: Add items to your invoice
        Invoice foundInv = invoiceTree.findInvoice("INV001");
        if (foundInv != null) {
            foundInv.addItem(rockyRoad.getIceID(), 4);
        }

        // Task 3: Remove items from your invoice
        foundInv = invoiceTree.findInvoice("INV002");
        if (foundInv != null) {
            foundInv.getItem().remove(cookiesNCream.getIceID());
        }

        // Task 4: Edit an item in your invoice
        foundInv = invoiceTree.findInvoice("INV001");
        if (foundInv != null) {
            foundInv.getItem().put(mintChip.getIceID(), 10);
        }

        // Task 5: Print your invoices
        System.out.println("List invoices:");
        invoiceTree.printInvoices();

        // Print a specific invoice
        String searchID = "INV001";
        foundInv = invoiceTree.findInvoice(searchID);
        if (foundInv != null) {
            System.out.println("Found invoice with ID " + searchID + ":");
            foundInv.printInvoice();
        } else {
            System.out.println("Not found invoice with ID " + searchID);
        }
    }
}
