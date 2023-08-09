public class CircularLinkedList {
    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    private Node head;
    private int size;

    public int getSize() {
        return size;
    }

    public CircularLinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            newNode.next = head;
            size++;
        } else {
            Node lastNode = head;
            while (lastNode.next != head) {
                lastNode = lastNode.next;
            }
            newNode.next = head;
            lastNode.next = newNode;
            head = newNode;
            size++;
        }
    }

    /** Index starts from 1 */
    public void addMid(int index, int data) {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        if (index < 1 || index > size) {
            System.out.print("Index not found");
            return;
        }
        if (index == 1) {
            addFirst(data);
        } else {
            Node newNode = new Node(data);
            Node previousNode = head;
            for (int i = 1; i < index - 1; i++) {
                previousNode = previousNode.next;
            }
            newNode.next = previousNode.next;
            previousNode.next = newNode;
            size++;
        }
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            newNode.next = head;
            size++;
        } else {
            Node lastNode = head;
            while (lastNode.next != head) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
            newNode.next = head;
            size++;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        if (size == 1) {
            clear();
        } else {
            Node lastNode = head;
            while (lastNode.next != head) {
                lastNode = lastNode.next;
            }
            lastNode.next = head.next;
            head = head.next;
            size--;
        }
    }

    public void removeMid(int index) {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        if (index < 1 || index > size) {
            System.out.println("Index not found");
            return;
        }
        if (index == 1) {
            removeFirst();
        } else {
            Node previousNode = head;
            for (int i = 1; i < index - 1; i++) {
                previousNode = previousNode.next;
            }
            previousNode.next = previousNode.next.next;
            size--;
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        if (size == 1) {
            clear();
        } else {
            Node secondLastNode = head;
            while (secondLastNode.next.next != head) {
                secondLastNode = secondLastNode.next;
            }
            secondLastNode.next = head;
            size--;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty");
        } else {
            Node currentNode = head;
            do {
                System.out.print(currentNode.data + " ");
                currentNode = currentNode.next;
            } while (currentNode != head);
            System.out.println();
        }

    }
}
