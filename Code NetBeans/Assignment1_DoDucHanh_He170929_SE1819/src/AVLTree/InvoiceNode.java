package avltree;

import object.Invoice;

public class InvoiceNode {

    Invoice invoice;
    InvoiceNode left;
    InvoiceNode right;
    int height;

    public InvoiceNode(Invoice invoice) {
        this.invoice = invoice;
        this.left = null;
        this.right = null;
        this.height = 1;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public InvoiceNode getLeft() {
        return left;
    }

    public void setLeft(InvoiceNode left) {
        this.left = left;
    }

    public InvoiceNode getRight() {
        return right;
    }

    public void setRight(InvoiceNode right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
