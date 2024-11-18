
package lap4.IntTree;

public class Node {
    private int data;
    Node right, left;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
    
}
