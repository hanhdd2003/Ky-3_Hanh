
package mybinarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class BSTree {

    Node root;

    public BSTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void visit(Node p) {
        if (p == null) {
            return;
        }
        System.out.print(p.info + "  ");
    }

    //return a Node which has key = given key in the tree p
    public Node search(Node p, int key) {
        if (p == null) {
            return null;
        }
        if (p.info == key) {
            return p;
        } else if (p.info > key) {
            return search(p.left, key);
        } else {
            return search(p.right, key);
        }
    }

    //insert a key x to the tree
    public void insert(int x) {
        Node p = new Node(x);
        Node f = null, q = root;
        while (q != null) {
            if (q.info == x) {
                return;
            }
            if (q.info < x) {
                f = q;
                q = q.right;
            } else {
                f = q;
                q = q.left;
            }
        }
        if (f == null) {
            root = p;
        } else if (p.info > f.info) {
            f.right = p;
        } else {
            f.left = p;
        }
    }

    //preorder a tree
    public void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    //postorder a tree
    public void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }

    //inorder a tree
    public void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    //bft
    public void BFT(Node p) {
        if (p == null) {
            return;
        }
        MyQueue m = new MyQueue();
        m.enqueue(p);
        while (!m.isEmpty()) {
            Node q = (Node) m.dequeue();
            visit(q);
            if (q.left != null) {
                m.enqueue(q.left);
            }
            if (q.right != null) {
                m.enqueue(q.right);
            }
        }
    }

    //height of tree
    int height(Node p) {
        if (p == null) {
            return 0;
        } else {
            int lDepth = height(p.left);//compute the depth of each subtree
            int rDepth = height(p.right);
            if (lDepth > rDepth) {
                return (lDepth + 1);//use the larger one
            } else {
                return (rDepth + 1);
            }
        }
    }

    /*Part 2___________________________________________________________________*/
    //delete a node on BST
    public void deleteByCopy(Node p) {
        if (p == null) {
            return;
        }
        //find f is father of p
        Node f = null, q = root;
        while (q != p) {
            f = q;
            if (q.info > p.info) {
                q = q.left;
            } else {
                q = q.right;
            }
        }
        //1.p has no child
        if (p.left == null && p.right == null) {
            if (f == null) {
                root = null;
            } else if (f.left == p) {
                f.left = null;
            } else {
                f.right = null;
            }
        } //2.p has left child only
        else if (p.left != null && p.right == null) {
            if (f == null) {
                root = p.left;
            } else if (f.left == p) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        } //3.p has right child only
        else if (p.left == null && p.right != null) {
            if (f == null) {
                root = p.right;
            } else if (f.left == p) {
                f.left = p.right;
            } else {
                f.right = p.right;
            }
        } //4.p has both child
        else if (p.left != null && p.right != null) {
            //tim q la node lon nhat ben con trai cua p -> q la con phai nhat
            //cua con trai cua p
            q = p.left;
            f = null;
            while (q.right != null) {
                f = q;
                q = q.right;
            }
            p.info = q.info;
            //delete q
            if (f == null) {
                p.left = q.left;
            } else {
                f.right = q.left;
            }
        }
    }

    /*public void deleByCopy(int xColor) {
        if (root == null) {
            return;
        }
        Node f, p; // f will be the father of p
        p = root;
        f = null;
        while (p != null) {
            if (p.info.sail == xColor) {
                break;//Found key x
            }
            if (xColor < p.info.sail) {
                f = p;
                p = p.left;
            } else {
                f = p;
                p = p.right;
            }
        }
        if (p == null) {
            System.out.println(" The key " + xColor + " does not exist, no deletion");
            return;
        }
        if (p.left == null && p.right == null) // p is a leaf node
        {
            if (f == null) // The tree is one node
            {
                root = null;
            } else {
                if (f.left == p) {
                    f.left = null;
                } else {
                    f.right = null;
                }
            }
            return;
        }
        if (p.left != null && p.right == null) // p has only left child
        {
            if (f == null) // p is a root
            {
                root = p.left;
            } else {
                if (f.left == p) // p is a left child
                {
                    f.left = p.left;
                } else {
                    f.right = p.left;
                }
            }
            return;
        }

        if (p.left == null && p.right != null) // p has only right child
        {
            if (f == null) // p is a root
            {
                root = p.right;
            } else {
                if (f.left == p) // p is aleft child
                {
                    f.left = p.right;
                } else {
                    f.right = p.right;
                }
            }
            return;
        }
        if (p.left != null && p.right != null) // p has both left and right children
        {
            Node q, fr, rp; // p's key will be replaced by rp's one
            fr = null;
            q = p.left;
            rp = q;
            while (rp.right != null) {
                fr = rp;
                rp = rp.right; // Find the right most node on the left sub-tree
            }
            p.info = rp.info;
            if (fr == null) // rp is just a left son of p 
            {
                p.left = rp.left;
            } else {
                fr.right = rp.left;
            }
        }
    } */
    
    public void deleteByMerging(int x) {
        Node p = search(root, x);
        if (p == null) {
            return;
        }
        //find f is father of p
        Node f = null, q = root;
        while (q != p) {
            f = q;
            if (q.info > p.info) {
                q = q.left;
            } else {
                q = q.right;
            }
        }
        //1.p has no child
        if (p.left == null && p.right == null) {
            if (f == null) {
                root = null;
            } else if (f.left == p) {
                f.left = null;
            } else {
                f.right = null;
            }
        } //2.p has left child only
        else if (p.left != null && p.right == null) {
            if (f == null) {
                root = p.left;
            } else if (f.left == p) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        } //3.p has right child only
        else if (p.left == null && p.right != null) {
            if (f == null) {
                root = p.right;
            } else if (f.left == p) {
                f.left = p.right;
            } else {
                f.right = p.right;
            }
        } //4.p has both child
        else if (p.left != null && p.right != null) {
            //tim q la node lon nhat ben con trai cua p -> q la con phai nhat
            //cua con trai cua p
            q = p.left;
            Node t = null;
            while (q.right != null) {
                t = q;
                q = q.right;
            }
            Node rp = p.right;
            q.right = rp;
            if (f == null) {
                root = p.left;
            } else if (f.left == p) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        }
    }

    //balancing a BST
    //inorder a BST and save all items to an array
    public void buildArray(ArrayList a, Node p) {
        if (p == null) {
            return;
        }
        buildArray(a, p.left);
        a.add(p);
        buildArray(a, p.right);
    }

    //insert all items from an array to a new BST
    public void balance(ArrayList a, int f, int l) {
        if (f > l) {
            return;
        }
        int m = (f + l) / 2;
        Node p = (Node) a.get(m);
        insert(p.info);
        balance(a, f, m - 1);
        balance(a, m + 1, l);
    }

    public void balance(Node p) {
        ArrayList a = new ArrayList();
        buildArray(a, p);
        int l = a.size(), f = 0;
        //create a new tree and insert all items from a to the BST
        BSTree t = new BSTree();
        t.balance(a, f, l - 1);
        root = t.root;
    }

    /*Part 3___________________________________________________________________*/
    
    
    void doRotateRight(Node p) {
        Node father = findParent(p);
        if (father.info > p.info) {
            father.left = rotateRight(p);
        } else {
            father.right = rotateRight(p);
        }
    }
    
    public Node rotateRight(Node p) {
        if (p.left == null) {
            return p;
        }
        Node p1 = p.left;
        p.left = p1.right;
        p1.right = p;
        return p1;
    }

    public Node rotateLeft(Node p) {
        if (p.right == null) {
            return p;
        }
        Node p1 = p.right;
        p.right = p1.left;
        p1.left = p;
        return p1;
    }

    void doRotateLeft(Node p) {
        Node father = findParent(p);
        if (father != null) {
            if (father.info > p.info) {
                father.left = rotateLeft(p);
            } else {
                father.right = rotateLeft(p);
            }
        } else {
            // Nếu `father` là `null`, nghĩa là `p` là nút gốc của cây,
            // sau khi quay trái, nút gốc mới là nút `p`.
            root = rotateLeft(p);
        }
    }

    Node findParent(Node x) {
        Node father, son;
        father = null;
        son = root;
        while (son != null) {
            if (son.info == x.info) {
                break;
            }
            father = son;
            if (x.info < son.info) {
                son = son.left;
            } else {
                son = son.right;
            }
        }
        return father;
    }

    public Node findMax(Node root) {
        Node current = root;
        if (current == null) {
            return null; // Cây rỗng.
        }

        while (current.right != null) {
            current = current.right;
        }

        return current; // Nút chứa giá trị lớn nhất.
    }

    public Node findMin(Node root) {
        Node current = root;
        if (current == null) {
            return null; // Cây rỗng.
        }

        while (current.left != null) {
            current = current.left;
        }

        return current; // Nút chứa giá trị lớn nhất.
    }

    public Node findSecondLargest(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return null; 
        }

        Node current = root;
        Node parent = null;

        // Di chuyển đến nút lớn nhất
        while (current.right != null) {
            parent = current;
            current = current.right;
        }

        // Nếu nút lớn nhất có nút con bên trái
        if (current.left != null) {
            current = current.left;
            while (current.right != null) {
                current = current.right;
            }
            return current;
        }

        // Nếu nút lớn nhất không có nút con bên trái, lấy nút cha của nút lớn nhất
        // (nút này sẽ là nút có giá trị lớn thứ hai)
        return parent;
    }

    public Node findSecondSmallest(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            // Cây rỗng hoặc cây chỉ có một nút
            return null; 
        }

        Node current = root;
        Node parent = null;

        // Di chuyển đến nút nhỏ nhất
        while (current.left != null) {
            parent = current;
            current = current.left;
        }

        // Nếu nút nhỏ nhất có nút con bên phải
        if (current.right != null) {
            current = current.right;
            while (current.left != null) {
                current = current.left;
            }
            return current;
        }

        // Nếu nút nhỏ nhất không có nút con bên phải, lấy nút cha của nút nhỏ nhất
        // (nút này sẽ là nút có giá trị nhỏ thứ hai)
        return parent;
    }
    
    //tim theo inorder
     Node findSecondNodeWithLeftChild(Node node, int count) {
        if (node == null) {
            return null;
        }

        Node leftResult = findSecondNodeWithLeftChild(node.left, count);

        if (leftResult != null) {
            return leftResult;
        }

        count++;

        if (count == 2 && node.left != null) {
            return node;
        }

        Node rightResult = findSecondNodeWithLeftChild(node.right, count);

        if (rightResult != null) {
            return rightResult;
        }

        return null;
    }

    
    
    
    //int count = 0; // Biến đếm để theo dõi vị trí node trong thứ tự duyệt

    int count = 0;

    Node get4thPreorder(Node node) {
        if (node == null) {
            return null;
        }

        count++;

        if (count == 4) {

            return node;
        }

        Node leftResult = get4thPreorder(node.left);
        if (leftResult != null) {
            return leftResult;
        }

        Node rightResult = get4thPreorder(node.right);
        return rightResult;
    }

    Node get4thInorder(Node node) {
        if (node == null) {
            return null;
        }

        Node leftResult = get4thInorder(node.left);
        if (leftResult != null) {
            return leftResult;
        }

        count++;
        if (count == 4) {
            return node;
        }

        Node rightResult = get4thInorder(node.right);
        return rightResult;
    }

    Node get4thPostorder(Node node) {
        if (node == null) {
            return null;
        }

        Node leftResult = get4thPostorder(node.left);
        Node rightResult = get4thPostorder(node.right);

        if (leftResult != null) {
            return leftResult;
        }

        if (rightResult != null) {
            return rightResult;
        }

        count++;
        if (count == 4) {
            return node;
        }

        return null;
    }

    Node get4thBFS() {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        int count = 0;

        queue.offer(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            count++;

            if (count == 4) {
                return current;
            }

            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        return null; // Trường hợp không tìm thấy node thứ 4
    }

    int count(Node p){
        return (p == null) ? 0 : 1 + count(p.left) + count(p.right);
    }
    
    public static void main(String[] args) {

//        int [] x = {60, 90, 80, 100, 50, 55, 40};
//        BSTree tree = new BSTree();
//        for(int i = 0; i < x.length; i++) tree.insert(x[i]);
//        tree.preOrder(tree.root);//60 50 40 55 90 80 100
//        System.out.println("");
//        tree.inOrder(tree.root);//40 50 55 60 80 90 100
//        System.out.println("");
//        tree.BFT(tree.root);
//        System.out.println("");
/*Part 2___________________________________________________________________*/
        int[] x = {44, 17,16, 78, 32, 50, 88, 48, 62, 54};
        BSTree tree = new BSTree();
        for (int i = 0; i < x.length; i++) {
            tree.insert(x[i]);
        }
        /*tree.BFT(tree.root);
        System.out.println("");
        tree.balance(tree.root);
        tree.BFT(tree.root);
        System.out.println("");*/
 /*Part 3___________________________________________________________________*/
        tree.preOrder(tree.root);
        System.out.println();
        System.out.println(tree.findSecondNodeWithLeftChild(tree.root, 0).info);
        //System.out.println(tree.get4thPreorder(tree.root).info);
        
    }
    
}
