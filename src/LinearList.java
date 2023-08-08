public class LinearList {
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    int size;
    Node head;

    LinearList() {
        head = null;
        size = 0;
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return head == null;
    }

    void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }

    boolean remove(int data) {
        if (isEmpty())
            return false;

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == data) {
                temp.next = temp.next.next;
                size--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    boolean removeFirst() {
        if (!isEmpty()) {
            head = head.next;
            size--;
            return true;
        }
        return false;
    }

    boolean removeLast() {
        if (!isEmpty()) {
            Node temp = head;
            if (temp.next == null) {
                temp = null;
                size--;
                return true;
            }
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            size--;
            return true;
        }

        return false;
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
