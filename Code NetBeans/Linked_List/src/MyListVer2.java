
// Lop BOAT
class Boat {

    String sea;
    int sail, paddle;

    Boat() {
    }

    Boat(String xSea, int xSail, int xPaddle) {
        sea = xSea;
        sail = xSail;
        paddle = xPaddle;
    }

    @Override
    public String toString() {
        return "(" + sea + "," + sail + "," + paddle + ")";
    }
}

// Lop Node
class Node {

    Boat info;
    Node next;

    Node() {
    }

    Node(Boat x, Node p) {
        info = x;
        next = p;
    }

    Node(Boat x) {
        this(x, null);
    }
}

public class MyListVer2 {

    Node head, tail;

    public MyListVer2() {
        head = tail = null;
    }

    // Kiem tra danh sach co rong hay khong
    boolean isEmpty() {
        return (head == null);
    }

    // Xoa toan bo danh sach
    void clear() {
        head = tail = null;
    }

    // Dem so phan tu trong danh sach
    int size() {
        int count = 0;
        Node node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    // Lay vi tri cua mot phan tu trong danh sach
    int getIndex(int sail) {
        int indexRes = 0;
        Node p = head;
        while (p != null) {
            if (p.info.sail == sail) {
                break;
            }
            indexRes++;
            p = p.next;
        }
        return indexRes;
    }

    // Lay phan tu tai vi tri cu the
    Node get(int pos) {
        Node p = head;
        while (pos-- > 0) {
            p = p.next;
        }
        return p;
    }

    // In ra toan bo phan tu trong danh sach
    void traverse() {
        Node node = head;
        while (node != null) {
            System.out.print(node.info + " ");
            node = node.next;
        }
        System.out.println("");
    }

    // Kiem tra xem mot gia tri co ton tai trong danh sach hay khong
    boolean exist(int sail) {
        Node node = head;
        while (node != null) {
            if (node.info.sail == sail) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    //--------------------------------------------------F1--------------------------------------------------//
    // Them mot phan tu vao cuoi danh sach
    void addLast(Boat info) {
        if (isEmpty()) {
            head = tail = new Node(info);
        } else {
            Node node = new Node(info);
            tail.next = node;
            tail = node;
        }
    }

    // Them mot phan tu vao dau danh sach
    void addFirst(Boat info) {
        if (isEmpty()) {
            head = tail = new Node(info);
        } else {
            Node node = new Node(info);
            node.next = head;
            head = node;
        }
    }

    //--------------------------------------------------F2--------------------------------------------------//
    // Them mot phan tu vao vi tri cu the
    void addPosition(int pos, Node x) {
        Node p = head;
        while (pos-- > 1) {
            p = p.next;
        }
        Node node = new Node(x.info, p.next);
        p.next = node;
    }

    // Them Node sau Node da cho
    void insertNodeAfter(Node node, Node newNode) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode == node) {
                newNode.next = currentNode.next;
                currentNode.next = newNode;
                if (newNode.next == null) {
                    tail = newNode;
                }
                return;
            }
            currentNode = currentNode.next;
        }
    }

    // Them Node truoc Node da cho
    void insertNodeBefore(Node node, Node newNode) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.next == node) {
                newNode.next = node;
                currentNode.next = newNode;
                return;
            }
            currentNode = currentNode.next;
        }
    }

    // Xoa phan tu dau danh sach
    void delFirst() {
        head = head.next;
    }

    // Xoa phan tu cuoi danh sach
    void delLast() {
        Node node = head;
        while (node.next.next != null) {
            node = node.next;
        }
        node.next = null;
        tail = node;
    }

        //--------------------------------------------------F3--------------------------------------------------//
    // Duyet list de tim phan tu co dieu kien 
    void f3(){
    Node p = head;
    int count = 0;
    while(p!=null){
            if (p.info.sail < 6) {    //dieu kien
            count++;
        }
        if (count == 2) {
            removeNode(p);              //hanh vi voi phan tu co dieu kien do
            break;
        }
        p = p.next;
    }}

    // Xoa mot phan tu (dung cho phan f3)
    void removeNode(Node nodeToRemove) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            if (current == nodeToRemove) {
                if (prev == null) {
                    // Neu Node can xoa la head
                    head = current.next;
                    if (head == null) {
                        // Neu danh sach chi co mot Node
                        tail = null;
                    }
                } else {
                    // Neu Node can xoa khong phai la head
                    prev.next = current.next;
                    if (current.next == null) {
                        // Neu Node can xoa la tail
                        tail = prev;
                    }
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    // Xoa phan tu co gia tri x khoi danh sach
    void delNodeHaveValueX(int x) {
        Node p = head;
        int i = 0;
        while (p != null) {
            if (p.info.sail == x) {
                break;
            }
            i++;
            p = p.next;
        }
        delPosition(i);
    }

    // Xoa phan tu tai vi tri cu the
    void delPosition(int pos) {
        int size = size();
        Node p = head;
        while (pos-- > 1) {
            p = p.next;
        }
        p.next = p.next.next;
    }

    // Xoa Node ngay sau Node da cho
    void deleteNodeAfter(Node node) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode == node && currentNode.next != null) {
                currentNode.next = currentNode.next.next;
                if (currentNode.next == null) {
                    tail = currentNode;
                }
                return;
            }
            currentNode = currentNode.next;
        }
    }

    // Xoa Node ngay truoc Node da cho
    void deleteNodeBefore(Node node) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.next == node) {
                currentNode.next = node.next;
                if (currentNode.next == null) {
                    tail = currentNode;
                }
                return;
            }
            currentNode = currentNode.next;
        }
    }

    
        //--------------------------------------------------F4--------------------------------------------------//
    // Sap xep danh sach theo thu tu tang dan
    void sort() {
        if (isEmpty()) {
            return;
        }
        Node pi = head, pj;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pi.info.sail > pj.info.sail) {
                    Boat temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    // Sap xep k phan tu dau tien theo thu tu tang dan
    void sortFirstKElements(int k) {
        for (int i = 0; i < k - 1; i++) {
            int count = 0;
            for (Node pj = head; count < k - 1; pj = pj.next) {
                count++;
                if (pj.info.sail > pj.next.info.sail) {
                    Boat temp = pj.info;
                    pj.info = pj.next.info;
                    pj.next.info = temp;
                }
            }
        }
    }

    // Sap xep k phan tu cuoi cung theo thu tu tang dan
    void sortLastKElements(int k) {
        int count = size() - k;
        Node pi = head, pj;
        while (count-- > 0) {
            pi = pi.next;
        }
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pi.info.sail > pj.info.sail) {
                    Boat temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    // Sap xep danh sach theo thu tu giam dan
    void sortDescending() {
        if (isEmpty()) {
            return;
        }
        Node pi = head, pj;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pi.info.sail < pj.info.sail) {
                    Boat temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    // Sap xep k phan tu dau tien theo thu tu giam dan
    void sortFirstKElementsDescending(int k) {
        for (int i = 0; i < k - 1; i++) {
            int count = 0;
            for (Node pj = head; count < k - 1; pj = pj.next) {
                count++;
                if (pj.info.sail < pj.next.info.sail) {
                    Boat temp = pj.info;
                    pj.info = pj.next.info;
                    pj.next.info = temp;
                }
            }
        }
    }

    // Sap xep k phan tu cuoi cung theo thu tu giam dan
    void sortLastKElementsDescending(int k) {
        int count = size() - k;
        Node pi = head, pj;
        while (count-- > 0) {
            pi = pi.next;
        }
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pi.info.sail < pj.info.sail) {
                    Boat temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    // Sap xep cac phan tu tu vi tri x den vi tri y theo thu tu tang dan
    void sortAscending(int x, int y) {
        Node px = get(x);
        for (int i = x; i < y - 1; i++) {
            for (int j = i + 1; j < y; j++) {
                Node pi = get(i);
                Node pj = get(j);
                if (pi.info.sail > pj.info.sail) {
                    Boat t = pi.info;
                    pi.info = pj.info;
                    pj.info = t;
                }
            }
        }
    }

    // Sap xep cac phan tu tu vi tri x den vi tri y theo thu tu giam dan
    void sortDescending(int x, int y) {
        Node px = get(x);
        for (int i = x; i < y - 1; i++) {
            for (int j = i + 1; j < y; j++) {
                Node pi = get(i);
                Node pj = get(j);
                if (pi.info.sail < pj.info.sail) {
                    Boat t = pi.info;
                    pi.info = pj.info;
                    pj.info = t;
                }
            }
        }
    }
    
    /* Bai sort tu x den y
    Node pos(int k) {
        Node p = head;
        int current = 0;
        while (p != null) {
            if (current == k) {
                return p;
            }
            p = p.next;
            current++;
        }
        return null;
    }
    void sortByweight(int from, int to) {
        if (isEmpty()) {
            return;
        }
        int tempInfo;
        for (int i = 0; i < this.size(); i++) {
            for (int j = from; j < to - i; j++) {
                if (pos(j).info.paddle > pos(j + 1).info.paddle) {
                    tempInfo = pos(j).info.paddle;
                    pos(j).info.paddle = pos(j + 1).info.paddle;
                    pos(j + 1).info.paddle = tempInfo;
                }
            }
        }
    }
    */
    

    // Dao nguoc danh sach
    void reverse() {
        Node prev = null, current = head, next;
        boolean updateTail = false;
        while (current != null) {
            next = current.next;
            current.next = prev;
            if (!updateTail) {
                tail = current;
                updateTail = true;
            }
            prev = current;
            current = next;
        }
        head = prev;
    }

    // Dao nguoc k phan tu dau tien
    void reverseFirstKElements(int k) {
        Node temp = head, connect;
        while (k-- > 1) {
            temp = temp.next;
        }
        connect = temp.next;
        temp.next = null;
        Node prev = null, current = head, next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = connect;
    }

    // Dao nguoc k phan tu cuoi cung
    void reverseLastKElements(int k) {
        int count = size() - k;
        Node temp = head;
        while (count-- > 1) {
            temp = temp.next;
        }
        Node tempNext = temp.next;
        temp.next = null;
        Node prev = null, current = tempNext, next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        tempNext = prev;
        Node px = tempNext;
        while (px.next != null) {
            px = px.next;
        }
        px.next = temp;
    }

    // Dao nguoc danh sach theo thu tu tang dan
    void reverseAscending(int x, int y) {
        Node px = get(x);
        Node py = get(y - 1);
        while (px != py) {
            Node pmin = px, pj;
            for (pj = px; pj != py; pj = pj.next) {
                if (pmin.info.sail > pj.info.sail) {
                    pmin = pj;
                }
            }
            Boat t = px.info;
            px.info = pmin.info;
            pmin.info = t;
            px = px.next;
        }
    }

    // Dao nguoc danh sach theo thu tu giam dan
    void reverseDescending(int x, int y) {
        Node px = get(x);
        Node py = get(y - 1);
        while (px != py) {
            Node pmax = px, pj;
            for (pj = px; pj != py; pj = pj.next) {
                if (pmax.info.sail < pj.info.sail) {
                    pmax = pj;
                }
            }
            Boat t = px.info;
            px.info = pmax.info;
            pmax.info = t;
            px = px.next;
        }
    }
    
    
    //Tim min
    public int min() {
        int min = Integer.MAX_VALUE;
        Node p = head;
        while (p != null) {
            if (p.info.sail < min) {
                min = p.info.sail;
            }
            p = p.next;
        }
        return min;
    }
    
    //Tim max
    public int max() {
		int max = Integer.MIN_VALUE;
		Node p = head;
		while (p != null) {
			if (p.info.sail > max) {
				max = p.info.sail;
			}
			p = p.next;
		}
		return max;
	}

    
    //Tim last min
    public Node searchf3v1(int min) {
        Node p = head;
        while (p != null) {
            if (p.info.sail == min) {
                return p;
            }
            p = p.next;
        }
        return null;
    }
    
    
    
    //Tim second min
    public Node searchf3v2(int max) {
        int count = 0;
		Node p = head;
		while (p != null) {
			if (p.info.sail == max) {
				count++;
				if (count == 2) {
					return p;
				}
			}
			p = p.next;
		}
		return null;
	}
}
