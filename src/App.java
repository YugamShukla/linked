public class App {
    public class Node {
        public int data;
        public Node next;

        public Node(int data, Node head) {
            this.data = data;
            this.next = head;
        }
    }

    public Node head;
    public int size = 0;
    public Node tail;

    public void addHead(int value) {
        head = new Node(value, head);
        size = size++;
    }

    public void addTail(int value) {
        Node newNode = new Node(value, null);
        Node curr = head;
        if (head == null) {
            head = newNode;
        }
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;

    }

    void addLast(int val) {
        Node temp = new Node(val, null);
        if (size == 0) {
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }

        size++;
    }

    public int getFirst() {
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        } else {
            return head.data;
        }
    }

    public void removeFirst() {
        if (size == 0) {
            System.out.println("List is empty");
        } else if (size == 1) {
            head = tail = null;
            size = 0;
        } else {
            head = head.next;
            size--;
        }
    }

    public void removeatPosition(int index) {
        Node temp = head;
        if (index == 0) {
            temp = temp.next;
        } else {
            // for loop is used to tell where do we need our temp to stop
            // after the finishing of loop we perform our task of deletion
            // deletion== cutting connection from linked lists
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }

    }

    public void getAtIndex(int index) {
        Node temp = head;
        if (index == 0) {
            System.out.println(temp.data);
        } else {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            System.out.println(temp.data);
        }

    }

    public void addAtIndex(int pos, int key) {
        Node newNode = new Node(key, null);
        Node temp = head;

        if (pos == 0) {
            newNode.next = temp;
            temp = newNode;
            size++;
        } else {
            for (int i = 0; i < pos - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node next = curr.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node temp = head;
        head = tail;
        tail = temp;
    }

    public int getnode(int pos) {
        Node temp = head;
        if (temp == null) {
            return head.data;
        }
        int s = 0;
        while (head != null) {
            s = s++;
        }
        for (int i = 0; i < s - pos; i++) {
            temp = temp.next;
        }
        return temp.data;

    }

    public void getfromtail(int pos) {
        Node fast = head;
        Node slow = head;
        for (int i = 0; i < pos; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        System.out.println(slow.data);
    }

    public void middle() {
        Node f = head;
        Node s = head;
        while (f.next != null && f.next.next != null) {
            f = f.next.next;
            s = s.next;
        }
        System.out.print(s.data);
    }

    public static void merge(App l1, App l2) {
        Node h1 = l1.head;
        Node h2 = l2.head;
        App ll3 = new App();
        while (h1 != null && h2 != null) {
            if (h1.data < h2.data) {
                ll3.addLast(h1.data);
                h1 = h1.next;
            } else if (h2.data < h1.data) {
                ll3.addLast(h2.data);
                h2 = h2.next;
            }
        }
        while (h1 != null) {
            ll3.addLast(h1.data);
            h1 = h1.next;
        }
        while (h2 != null) {
            ll3.addLast(h2.data);
            h2 = h2.next;
        }
        ll3.print();
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public void oddeven() {
        App odd = new App();
        App even = new App();
        while (this.size > 0) {
            int val = this.getFirst();
            this.removeFirst();
            if (val % 2 == 0) {
                even.addLast(val);
            } else {
                odd.addLast(val);
            }
        }
        if (odd.size > 0 && even.size > 0) {
            odd.tail.next = even.tail;
            this.head = odd.head;
            this.tail = even.tail;
            this.size = odd.size + even.size;
        } else if (odd.size > 0) {
            this.head = odd.head;
            this.tail = odd.tail;
            this.size = odd.size;
        } else if (even.size > 0) {
            this.head = even.head;
            this.tail = even.tail;
            this.size = even.size;
        }

    }

    private void foldhelper(Node right, int floor) {
        if (right == null) {
            return;
        }
        foldhelper(right.next, floor + 1);
        if (floor > size / 2) {
            Node temp = fleft.next;
            fleft.next = right;
            right.next = temp;
            fleft = temp;
        } else if (floor == size / 2) {
            tail = right;
            tail.next = right;
        }
    }

    Node fleft;

    public void fold() {
        fleft = head;
        foldhelper(head, 0);
    }

    public static void intersectiony(App one, App two) {
        Node t1 = one.head;
        Node t2 = two.head;
        int delta = Math.abs(one.size - two.size);
        if (one.size > two.size) {
            for (int i = 0; i < delta; i++) {
                t1 = t1.next;
            }
        } else {
            for (int i = 0; i < delta; i++) {
                t2 = t2.next;
            }
        }
        while (t1 != t2) {
            t1 = t1.next;
            t2 = t2.next;
        }
        System.out.println(t1.data);
    }

    public static void main(String[] args) {
        App ll1 = new App();
        App ll2 = new App();
        ll1.addHead(2);
        ll1.addTail(9);
        ll1.addTail(7);
        ll1.addTail(8);
        ll1.print();
        System.out.println();
        ll2.addHead(5);
        ll2.addTail(15);
        ll2.addTail(35);
        ll2.addTail(45);

        ll2.print();
        System.out.println();
        ll1.getAtIndex(1);
        ll1.addAtIndex(4, 50);
        ll1.print();
        System.out.println();
        ll1.removeatPosition(4);
        ll1.print();
        System.out.println();
        ll1.addAtIndex(4, 50);
        ll1.print();
        System.out.println();
        ll1.getfromtail(3);
        ll2.middle();
        System.out.println();
        App.merge(ll1, ll2);
        System.out.println();
        ll1.oddeven();
        App.intersectiony(ll1, ll2);

    }
}
