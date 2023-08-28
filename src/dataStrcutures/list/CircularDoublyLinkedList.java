package dataStrcutures.list;

/*
 * addToEmpty(value)
 * deleteNodeByKey(key)
 * traverseForward()
 * traverseBackward()
 * search(key)
 * getFirst()
 * getLast()
 */
public class CircularDoublyLinkedList {

    private static class Node {

        int data;
        Node next;
        Node prev;

        private Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    private int size;
    private Node head;

    public CircularDoublyLinkedList() {
        size = 0;
        head = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void addFirst(int data) {
        if (isEmpty()) {
            head = new Node(data);
            head.next = head.prev = head;
            size++;
            return;
        }

        Node newNode = new Node(data);
        newNode.next = head;
        newNode.prev = head.prev;
        head.prev.next = newNode;
        head.prev = newNode;
        head = newNode;
        size++;

    }

    /** Index starts from 1 */
    public void addMid(int index, int data) {
        if (isEmpty()) {
            System.err.println("List is empty");
            return;
        }

        if (index < 1 || index > size) {
            System.err.println("Index out of bound");
            return;
        }

        if (index == 1) {
            addFirst(data);
        } else {
            Node newNode = new Node(data);
            Node currNode = head;
            for (int i = 1; i < index - 1; i++) {
                currNode = currNode.next;
            }
            newNode.next = currNode.next;
            newNode.prev = currNode;
            currNode.next.prev = newNode;
            currNode.next = newNode;
            size++;
        }

    }

    public void addLast(int data) {
        if (isEmpty()){
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        newNode.next = head;
        newNode.prev = head.prev;
        head.prev.next = newNode;
        head.prev = newNode;
        size++;

    }

    public void removeFirst() {
        if (isEmpty()) {
            System.err.println("List is empty");
            return;
        }

        if (size == 1) {
            clear();
            return;
        }

        head.prev.next = head.next;
        head.next.prev = head.prev;
        head = head.next;
        size--;

    }

    public void removeMid(int index) {
        if (isEmpty()) {
            System.err.println("List is empty");
            return;
        }

        if (index < 1 || index > size) {
            System.err.println("Index out of bound");
            return;
        }

        if (index == 1) {
            removeFirst();
            return;
        }

        Node currNode = head;
        for(int i=1; i<index-1; i++){
            currNode = currNode.next;
        }
        currNode.next.next.prev = currNode;
        currNode.next = currNode.next.next;
        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            System.err.println("List is empty");
            return;
        }

        if (size == 1) {
            clear();
            return;
        }

        head.prev.prev.next = head;
        head.prev = head.prev.prev;
        size--;
    }

    public void display() {
        if (isEmpty()) {
            System.err.println("List is empty");
            return;
        }

        Node currNode = head;
        do {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        } while (currNode != head);
        System.out.println();
    }
}
