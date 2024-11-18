
package lap4.StringTree;

public class Node {
    String data;
    Node left,right;

    public Node() {
    }

    public Node(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
}
