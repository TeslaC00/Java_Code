public class DoublyLinkedList {
    private static class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }

    private Node head;
    private int size;

    public DoublyLinkedList() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    private void clear() {
        head = null;
        size = 0;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            size++;
        } else {
            head.prev = newNode;
            newNode.next = head;
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
            System.out.println("Index not found");
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
            newNode.prev = previousNode;
            previousNode.next.prev = newNode;
            previousNode.next = newNode;
            size++;
        }
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            size++;
        } else {
            Node lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
            newNode.prev = lastNode;
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
            head.next.prev = null;
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
        } else if (index == size) {
            removeLast();
        } else {
            Node indexNode = head;
            for (int i = 1; i < index; i++) {
                indexNode = indexNode.next;
            }
            indexNode.next.prev = indexNode.prev;
            indexNode.prev.next = indexNode.next;
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
            while (secondLastNode.next.next != null) {
                secondLastNode = secondLastNode.next;
            }
            secondLastNode.next.prev = null;
            secondLastNode.next = null;
            size--;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty");
        } else {
            Node currentNode = head;
            while (currentNode != null) {
                System.out.print(currentNode.data + " ");
                currentNode = currentNode.next;
            }
            System.out.println();
        }
    }

}
