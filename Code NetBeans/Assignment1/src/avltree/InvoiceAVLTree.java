/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avltree;

import object.Invoice;

/**
 *
 * @author Hanh
 */
public class InvoiceAVLTree {

    InvoiceNode root;

    public void addInvoice(Invoice invoice) {
        this.insert(root, invoice);
    }
    public void delete(String invoiceID){
        this.delete(root, invoiceID);
    }
    public void printInvoices(){
        this.printInOrder(root);
    }
    public Invoice findInvoice(String id){
        return this.search(root, id);
    }

    private InvoiceNode insert(InvoiceNode node, Invoice invoice) {
        if (node == null) {
            return new InvoiceNode(invoice);
        }
        // so sánh id và chèn
        if (invoice.getInvoiceID().compareTo(node.getInvoice().getInvoiceID()) < 0) {
            node.left = insert(node.left, invoice);
        } else if (invoice.getInvoiceID().compareTo(node.getInvoice().getInvoiceID()) > 0) {
            node.right = insert(node.right, invoice);
        }
        // cập nhật chiều cao của tree
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // kiểm tra cây cân bằng
        int balance = balanceFactor(node);
        if (balance > 1) {
            if (invoice.getInvoiceID().compareTo(node.left.getInvoice().getInvoiceID()) < 0) {
                return rightRotate(node);
            } else {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if (balance < -1) {
            if (invoice.getInvoiceID().compareTo(node.right.getInvoice().getInvoiceID()) > 0) {
                return leftRotate(node);
            } else {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    private InvoiceNode delete(InvoiceNode node, String invoiceId) {
        if (node == null) {
            return node;
        }
        if (invoiceId.compareTo(node.getInvoice().getInvoiceID()) < 0) {
            node.left = delete(node.left, invoiceId);
        } else if (invoiceId.compareTo(node.getInvoice().getInvoiceID()) > 0) {
            node.right = delete(node.right, invoiceId);
        } else {
            if (node.left == null || node.right == null) {
                InvoiceNode temp = (node.left != null) ? node.left : node.right;
                if (temp == null) {
                    temp = node;
                    node = null;
                } else {
                    node = temp;
                }

            } else {
                InvoiceNode temp = findMin(node.right);
                node.right = delete(node.right, temp.getInvoice().getInvoiceID());
            }
        }
        if (node == null) {
            return node;
        }
        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = balanceFactor(node);

        if (balance > 1) {
            if (balanceFactor(node.left) >= 0) {
                return rightRotate(node);
            } else {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (balance < -1) {
            if (balanceFactor(node.right) <= 0) {
                return leftRotate(node);
            } else {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    private Invoice search(InvoiceNode node, String invoiceID) {
        if (node == null) {
            return null;
        }

        if (invoiceID.compareTo(node.getInvoice().getInvoiceID()) < 0) {
            return search(node.left, invoiceID);
        } else if (invoiceID.compareTo(node.getInvoice().getInvoiceID()) > 0) {
            return search(node.right, invoiceID);
        } else {
            return node.getInvoice();
        }
    }

    public void printInOrder(InvoiceNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println("Invoice ID: " + node.getInvoice().getInvoiceID());
            System.out.println("Customer ID: " + node.getInvoice().getCustomerID());
            //System.out.println("Ice Creams: " + node.getInvoice().getIceCreams());
            System.out.println("Total: " + node.getInvoice().getTotal());
            System.out.println();
            printInOrder(node.right);
        }
    }
//-------------------------------------------

    private InvoiceNode rightRotate(InvoiceNode y) {
        InvoiceNode x = y.left;
        InvoiceNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private InvoiceNode leftRotate(InvoiceNode x) {
        InvoiceNode y = x.right;
        InvoiceNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    private InvoiceNode findMin(InvoiceNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    
    private int height(InvoiceNode node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }

    private int balanceFactor(InvoiceNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }
    
    
}
