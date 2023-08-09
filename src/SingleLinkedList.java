/*
 * contains()
 * get(index)
 * set(index,data)
 * indexOf(data)
 * insertAfter(node, data)
 * insertBefore(node, data)
 * remove(data)
 * reverse()
 * toArray()
 * iterator()
 * toString()
 */
public class SingleLinkedList {
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private int size;
    private Node head;

    public SingleLinkedList() {
        head = null;
        size = 0;
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
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
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
        if (index == 1)
            addFirst(data);
        else {
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
        } else {
            Node lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
        size++;
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.err.println("List is empty");
            return;
        }
        if (size == 1) {
            clear();
        } else {
            head = head.next;
            size--;
        }
    }

    /** Index starts from 1 */
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
        }

        else {
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
            System.err.println("List is empty");
            return;
        }
        if (size == 1) {
            clear();
        } else {
            Node secondLastNode = head;
            while (secondLastNode.next.next != null) {
                secondLastNode = secondLastNode.next;
            }
            secondLastNode.next = null;
            size--;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.err.println("List is empty");
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
