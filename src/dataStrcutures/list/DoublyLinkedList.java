package dataStrcutures.list;

/*
 * insertBefore(node, value)
 * insertAfter(node, value)
 * remove(node)
 * iterateForward()
 * iterateBackward()
 * find(value)
 * findAll(value)
 * getFirst(): Get the value of the first node in the list.
 * getLast(): Get the value of the last node in the list.
 * getAt(index): Get the value of the node at the specified index
 * setValue(node, value)
 */

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
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
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
        tail = null;
        size = 0;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
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
            System.err.println("List is empty");
            return;
        }
        if (index < 1 || index > size) {
            System.err.println("Index not found");
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
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            size++;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.err.println("List is empty");
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
            System.err.println("List is empty");
            return;
        }
        if (index < 1 || index > size) {
            System.err.println("Index not found");
            return;
        }
        if (index == 1) {
            removeFirst();
        } else if (index == size) {
            removeLast();
        } else {
            Node currNode = head;
            for (int i = 1; i < index; i++) {
                currNode = currNode.next;
            }
            currNode.next.prev = currNode.prev;
            currNode.prev.next = currNode.next;
            size--;
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            System.err.println("List is empty");
            return;
        }
        if (size == 1) {
            clear();
        } else {
            tail = tail.prev;
            tail.next = null;
            size--;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.err.println("List is empty");
        } else {
            Node currNode = head;
            while (currNode != null) {
                System.out.print(currNode.data + " ");
                currNode = currNode.next;
            }
            System.out.println();
        }
    }

}
