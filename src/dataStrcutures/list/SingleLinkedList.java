package dataStrcutures.list;

/*
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

    private class EmptyListException extends RuntimeException {
        public EmptyListException() {
            super("List is empty");
        }
    }

    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
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
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }

    /** Index starts from 1 */
    public void addMid(int index, int data) {
        if (isEmpty())
            throw new EmptyListException();

        if (index < 1 || index > size)
            throw new IndexOutOfBoundsException("Index is out of bound");

        if (index == 1)
            addFirst(data);
        else {
            Node newNode = new Node(data);
            Node previousNode = head;
            for (int i = 1; i < index - 1; i++) {
                previousNode = previousNode.getNext();
            }
            newNode.setNext(previousNode.getNext());
            previousNode.setNext(newNode);
            size++;
        }
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node lastNode = head;
            while (lastNode.getNext() != null) {
                lastNode = lastNode.getNext();
            }
            lastNode.setNext(newNode);
        }
        size++;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new EmptyListException();

        if (size == 1) {
            clear();
        } else {
            head = head.getNext();
            size--;
        }
    }

    /** Index starts from 1 */
    public void removeMid(int index) {
        if (isEmpty())
            throw new EmptyListException();

        if (index < 1 || index > size)
            throw new IndexOutOfBoundsException("Index is out of bound");

        if (index == 1)
            removeFirst();

        else {
            Node previousNode = head;
            for (int i = 1; i < index - 1; i++) {
                previousNode = previousNode.getNext();
            }
            previousNode.setNext(previousNode.getNext().getNext());
            size--;
        }
    }

    public void removeLast() {
        if (isEmpty())
            throw new EmptyListException();
        if (size == 1) {
            clear();
        } else {
            Node secondLastNode = head;
            while (secondLastNode.getNext().getNext() != null) {
                secondLastNode = secondLastNode.getNext();
            }
            secondLastNode.setNext(null);
            size--;
        }
    }

    public boolean contains(int value) {
        if (isEmpty())
            throw new EmptyListException();

        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.getData() == value)
                return true;
            currentNode = currentNode.getNext();
        }
        return false;
    }

    public void display() {
        if (isEmpty())
            throw new EmptyListException();
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

}
