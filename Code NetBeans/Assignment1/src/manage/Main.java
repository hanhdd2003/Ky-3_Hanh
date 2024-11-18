/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import avltree.InvoiceAVLTree;
import object.Customer;
import object.IceCream;
import object.Invoice;

/**
 *
 * @author Hanh
 */
public class Main {
    public static void main(String[] args) {
        // Tạo một đối tượng AVLTree để quản lý hóa đơn
        InvoiceAVLTree invoiceTree = new InvoiceAVLTree();

        // Tạo một vài loại kem
        IceCream vanilla = new IceCream("V001", "Vanilla", "Regular", 2.5);
        IceCream chocolate = new IceCream("C001", "Chocolate", "Regular", 2.8);
        IceCream strawberry = new IceCream("S001", "Strawberry", "Premium", 3.5);

        // Tạo một vài khách hàng
        Customer customer1 = new Customer("CUST001", "Alice", "123-456-7890");
        Customer customer2 = new Customer("CUST002", "Bob", "987-654-3210");

        // Tạo hóa đơn cho khách hàng
        Invoice invoice1 = new Invoice("INV001",customer1.getCustomerID(), vanilla.getIceID(), 5);
        Invoice invoice2 = new Invoice("INV002", customer2.getCustomerID(),chocolate.getIceID(), 3);

        // Thêm hóa đơn vào cây AVL
        invoiceTree.addInvoice(invoice1);
        invoiceTree.addInvoice(invoice2);

        // In ra danh sách các hóa đơn
        System.out.println("Danh sách hóa đơn:");
        invoiceTree.printInvoices();

        // Tìm và in hóa đơn theo ID
        String searchID = "INV002";
        Invoice foundInvoice = invoiceTree.findInvoice(searchID);
        if (foundInvoice != null) {
            System.out.println("Tìm thấy hóa đơn với ID " + searchID + ":");
            foundInvoice.printInvoice();
        } else {
            System.out.println("Không tìm thấy hóa đơn với ID " + searchID);
        }

        // Xóa hóa đơn
        String deleteID = "INV001";
        invoiceTree.delete(deleteID);
        System.out.println("Đã xóa hóa đơn với ID " + deleteID + ". Danh sách hóa đơn sau khi xóa:");
        invoiceTree.printInvoices();
    }
}
