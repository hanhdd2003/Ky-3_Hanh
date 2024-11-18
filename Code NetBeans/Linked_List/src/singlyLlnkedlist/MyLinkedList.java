
package singlyLlnkedlist;


public class MyLinkedList {

    Node head;
    Node tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }
    
    public void addFirst(int x) {
        Node newNode = new Node(x);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.size++;
    }

    public void addLast(int x) {
        Node newNode = new Node(x);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    public void addBeforeK(int k, int x) {
        if (k < 0 || (k >= this.size)) {
        } else if (k == 0) {
            this.addFirst(x);
            return;
        }
        int count = 0;
        Node before = this.head;
        Node currentNode = this.head;
        while (currentNode != null) {
            if (count == k) {
                Node newNode = new Node(x);
                before.next = newNode;
                newNode.next = currentNode;
                this.size++;
            }
            before = currentNode;
            currentNode = currentNode.next;
            count++;
        }

    }

    public void addAfterk(int k, int x) {

        if (k < -1 || k >= this.size) {
        } else if (k == -1) {
            this.addFirst(x);
        } else if (k == this.size - 1) {
            this.addLast(x);
        } else {
            int count = 0;
            Node newNode = new Node(x);
            Node current = this.head;
            while (count < k || count > k) {
                current = current.next;
                count++;
            }
            newNode.next = current.next;
            current.next = newNode;
            this.size++;
        }
    }
// Thêm một node vào vị trí k trong danh sách liên kết

    public void insertAtPosition(int data, int k) {
        Node newNode = new Node(data);
        if (k < 0) {
            return;
        }
        if (k == 0) {
            this.addFirst(data);
            return;
        }
        if (k == this.getSize() - 1) {
            this.addLast(data);
            return;
        }
        Node current = head;
        int position = 1;
        while (position < k - 1 && current != null) {
            current = current.next;
            position++;
        }
        if (current == null) {
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public void insertBeforeNode(Node targetNode, int data) {
        if (head == null || targetNode == null) {
            return; // Không thể thêm trước nếu danh sách rỗng hoặc nút mục tiêu là null
        }

        Node newNode = new Node(data);
        newNode.next = targetNode;

        if (head == targetNode) {
            head = newNode; // Nếu nút mục tiêu là đầu danh sách, cập nhật đầu danh sách
            return;
        }

        Node current = head;
        while (current != null && current.next != targetNode) {
            current = current.next;
        }

        if (current != null) {
            current.next = newNode;
        }
    }

    public void insertAfterNode(Node targetNode, int data) {
        if (targetNode == null) {
            return; // Không thể thêm sau nếu nút mục tiêu là null
        }

        Node newNode = new Node(data);
        newNode.next = targetNode.next;
        targetNode.next = newNode;
    }

    // duyệt qua các phần tử của linked list để in ra
    public void traverse() {
        Node tmp = this.head;
        while (tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public int findIndex(int data) {
        Node current = this.head;
        int count = 0;
        int index = -1;
        while (current != null) {
            if (current.data == data) {
                index = count;
                break;
            }
            current = current.next;
            count++;
        }
        return index;
    }

    public int getNode_SecondHaveData(int data) {
        Node current = this.head;
        int count = 0;
        int index = -1;
        while (current != null) {
            if (current.data == data) {
                if (index == 0) {
                    index = count;
                    break;
                }
                index++;
            }
            current = current.next;
            count++;
        }
        return index;
    }

    public Node getNodeByIndex(int index) {
        if (index < 1) {
            return null;
        }

        Node current = head;
        int position = 0;

        while (position < index && current != null) {
            current = current.next;
            position++;
        }

        if (current == null) {
            return null;
        }

        return current;
    }

    public void delete(int data) {
        int a = findIndex(data);
        if (a == -1) {
            return;
        } else if (a == 0) {
            this.deleteFirst();
        } else if (a == this.size - 1) {
            this.deleteLast();
        } else {
            Node prev = this.head;
            Node current = prev.next;
            Node next = current.next;
            while (current != null) {
                if (current.data == data) {
                    break;
                }
                prev = current;
                current = next;
                next = next.next;
            }
            prev.next = next;
            this.size--;
        }
    }

    public void deleteFirst() {
        if (this.head != null) {
            Node firstNode = this.head;
            Node secondNode = firstNode.next;
            firstNode = null;
            this.head = secondNode;
            this.size--;
        } 
    }

    public void deleteLast() {
        if (this.head != null) {
            Node current = this.head;
            int count = 0;
            while (current != null) {
                if (count == this.size - 2) {
                    break;
                }
                current = current.next;
                count++;
            }
            current.next = null;
            this.tail = current;
            this.size--;
        } 
    }

    public void deleteAtPosition(int k) {
        if (k < 0) {
            return;
        }
        if (k == 0) {
            if (head != null) {
                head = head.next;
            }
            return;
        }
        Node current = head;
        int position = 0;

        while (position < k - 1 && current != null) {
            current = current.next;
            position++;
        }
        if (current == null || current.next == null) {
            return;
        }
        current.next = current.next.next;
    }
// Xóa một node tại vị trí k trong danh sách liên kết

    public void deleteBeforeK(int k) {
        if (head == null || head.next == null || k <= 1) {
            // Không đủ nút để xóa hoặc k là vị trí đầu danh sách, không có nút trước để xóa
            return;
        }

        if (k == 2) {
            // Xóa nút đầu danh sách
            head = head.next;
            return;
        }

        Node current = head;
        int position = 1;

        while (position < k - 2 && current != null && current.next != null) {
            current = current.next;
            position++;
        }

        if (current == null || current.next == null) {
            return;
        }

        current.next = current.next.next;
    }

    public void deleteAfterK(int k) {
        if (head == null || k < 0) {
            return; // Danh sách rỗng hoặc vị trí k không hợp lệ
        }

        Node current = head;
        int position = 0;

        while (position < k && current != null) {
            current = current.next;
            position++;
        }

        if (current == null || current.next == null) {
            return; // Không đủ nút để xóa sau k hoặc vị trí k không tồn tại
        }

        current.next = current.next.next;
    }

    public void deleteBeforeNode(Node targetNode) {
        if (head == null || head == targetNode || targetNode == null) {
            return; // Không có gì để xóa
        }

        if (head.next == targetNode) {
            head = head.next; // Xóa nút đầu
            return;
        }

        Node current = head;
        while (current != null && current.next != targetNode) {
            current = current.next;
        }

        if (current != null) {
            current.next = targetNode;
        }
    }

    public void deleteAfterNode(Node targetNode) {
        if (targetNode == null || targetNode.next == null) {
            return; // Không có gì để xóa
        }

        targetNode.next = targetNode.next.next;
    }

    public void sortAscending() {
        if (head == null || head.next == null) {
            return; // Không cần sắp xếp nếu danh sách rỗng hoặc chỉ có một nút
        }

        Node sorted = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            if (sorted == null || current.data <= sorted.data) {
                current.next = sorted;
                sorted = current;
            } else {
                Node search = sorted;
                while (search.next != null && current.data > search.next.data) {
                    search = search.next;
                }
                current.next = search.next;
                search.next = current;
            }
            current = next;
        }
        head = sorted;
    }

    public void sortDescending() {
        if (head == null || head.next == null) {
            return; // Không cần sắp xếp nếu danh sách rỗng hoặc chỉ có một nút
        }

        Node current = head;
        while (current != null) {
            Node temp = current;
            while (temp != null) {
                if (current.data < temp.data) { // So sánh theo chiều giảm dần
                    int tempData = current.data;
                    current.data = temp.data;
                    temp.data = tempData;
                }
                temp = temp.next;
            }
            current = current.next;
        }
    }

    boolean isEmpty() {
        return (head == null);
    }

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
        for (int i = 0; i < this.getSize(); i++) {
            for (int j = from; j < to - i; j++) {
                if (pos(j).data > pos(j + 1).data) {
                    tempInfo = pos(j).data;
                    pos(j).data = pos(j + 1).data;
                    pos(j + 1).data = tempInfo;
                }
            }
        }
    }
    
    public int getSize() {
        int count = 0;
        Node node = this.head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }


    public int max() {
        Node curr = this.head;
        int max = this.head.data;
        while (curr != null) {
            if (curr.data > max) {
                max = curr.data;
            }
            curr = curr.next;
        }
        return max;
    }

    //-----------------19-----------------
    public int min() {
        Node curr = this.head;
        int min = this.head.data;
        while (curr != null) {
            if (curr.data < min) {
                min = curr.data;
            }
            curr = curr.next;
        }
        return min;
    }

    //-----------------20-----------------
    public int sum() {
        int data = 0;
        Node current = this.head;
        while (current != null) {
            data = data + current.data;
            current = current.next;
        }
        return data;
    }

    public int maxIndexFirst() {
        int index = -1;
        int count = 0;
        Node curr = this.head;
        int max = this.head.data;
        while (curr != null) {
            if (curr.data > max) {
                max = curr.data;
                index = count;
            }
            count++;
            curr = curr.next;
        }
        return index;
    }

    public int findSecondLargestIndex() {
        if (head == null || head.next == null) {
            return -1; // Không có đủ phần tử để tìm phần tử lớn thứ hai
        }

        int firstMax = Integer.MIN_VALUE;
        int firstMaxIndex = -1;

        int secondMax = Integer.MIN_VALUE;
        int secondMaxIndex = -1;

        int currentIndex = 0;

        Node current = head;

        while (current != null) {
            if (current.data > firstMax) {
                secondMax = firstMax;
                secondMaxIndex = firstMaxIndex;
                firstMax = current.data;
                firstMaxIndex = currentIndex;
            } else if (current.data > secondMax && current.data < firstMax) {
                secondMax = current.data;
                secondMaxIndex = currentIndex;
            } else if (current.data == firstMax && firstMaxIndex != currentIndex) {
                secondMax = current.data;
                secondMaxIndex = currentIndex;
            }

            currentIndex++;
            current = current.next;
        }

        if (secondMaxIndex != -1) {
            return secondMaxIndex;
        } else {
            return -1;
        }
    }

    public int findSecondSmallestIndex() {
        if (head == null || head.next == null) {
            return -1; // Không có đủ phần tử để tìm phần tử nhỏ thứ hai
        }

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        int smallestIndex = -1;
        int secondSmallestIndex = -1;
        int currentIndex = 0;

        Node current = head;

        while (current != null) {
            if (current.data < smallest) {
                secondSmallest = smallest;
                secondSmallestIndex = smallestIndex;
                smallest = current.data;
                smallestIndex = currentIndex;
            } else if (current.data < secondSmallest && current.data > smallest) {
                secondSmallest = current.data;
                secondSmallestIndex = currentIndex;
            }else if (current.data == smallest && smallestIndex != currentIndex) {
                secondSmallest = current.data;
                secondSmallestIndex = currentIndex;
            }
            currentIndex++;
            current = current.next;
        }

        if (secondSmallestIndex != -1) {
            return secondSmallestIndex;
        } else {
            return -1; // Không tìm thấy phần tử nhỏ thứ hai
        }
    }

    public int minIndexFirst() {
        int index = 0;
        int count = 0;
        Node curr = this.head;
        int min = this.head.data;
        while (curr != null) {
            if (curr.data < min) {
                min = curr.data;
                index = count;
            }
            count++;
            curr = curr.next;
        }
        return index;
    }

    public void sortFirstKElements(int k) {
        for (int i = 0; i < k - 1; i++) {
            int count = 0;
            for (Node pj = head; count < k - 1; pj = pj.next) {
                count++;
                if (pj.data > pj.next.data) {
                    int temp = pj.data;
                    pj.data = pj.next.data;
                    pj.next.data = temp;
                }
            }
        }
    }

    /*void sortFirstKElements(int k) {
        for (int i = 0; i < k - 1; i++) {
            int count = 0;
            for (Node pj = head; count < k - 1; pj = pj.next) {
                count++;
                if (pj.info.type < pj.next.info.type) {
                    Ball temp = pj.info;
                    pj.info = pj.next.info;
                    pj.next.info = temp;
                }
            }
        }
    }*/
    
    public void sortLastKElements(int k) {
        int count = size() - k;
        Node pi = head, pj;
        while (count-- > 0) {
            pi = pi.next;
        }

        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pi.data > pj.data) {
                    int temp = pi.data;
                    pi.data = pj.data;
                    pj.data = temp;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    public void reverse() {
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

    public void reverseFirstKElements(int k) {
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

    public void reverseLastKElements(int k) {
        int count = size() - k;
        Node connect = head;
        while (count-- > 1) {
            connect = connect.next;
        }

        Node prev = null, current = connect.next, next;
        connect.next = tail;
        tail = current;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();
        myList.addLast(2);
        myList.addLast(5);
        myList.addLast(1);
        myList.addLast(4);
        myList.addFirst(1);
        myList.addAfterk(3, 5);
        myList.addLast(4);

        myList.traverse();
        myList.sortByweight(2, 6);
        myList.traverse();
        //System.out.println(myList.minIndexFirst());
        //System.out.println(myList.getNodeByIndex(myList.getNode_SecondHaveData(5)).data);
    }
    
}
