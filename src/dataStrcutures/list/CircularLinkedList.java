package dataStrcutures.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * addToEmpty(value)
 * deleteNodeByKey(key): Delete the first node with the given value from the list.
 * traverse()
 */

public class CircularLinkedList implements Iterable<Integer> {

    private class EmptyListException extends RuntimeException {
        public EmptyListException() {
            super("List is Empty");
        }
    }

    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    private Node tail;
    private int size;

    public int getSize() {
        return size;
    }

    public CircularLinkedList() {
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return tail == null;
    }

    public void clear() {
        tail = null;
        size = 0;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            tail = newNode;
            newNode.next = tail;
            size++;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
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
            Node currNode = tail.next;
            for (int i = 1; i < index - 1; i++) {
                currNode = currNode.next;
            }
            newNode.next = currNode.next;
            currNode.next = newNode;
            size++;
        }
    }

    public void addLast(int data) {
        addFirst(data);
        tail = tail.next;
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.err.println("List is empty");
            return;
        }
        if (size == 1) {
            clear();
        } else {
            tail.next = tail.next.next;
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
            Node currNode = tail.next;
            for (int i = 1; i < index - 1; i++) {
                currNode = currNode.next;
            }
            currNode.next = currNode.next.next;
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
            Node currNode = tail.next;
            while (currNode.next != tail) {
                currNode = currNode.next;
            }
            currNode.next = tail.next;
            tail = currNode;
            size--;
        }
    }

    public boolean contains(int data) {
        if (isEmpty()) {
            throw new EmptyListException();
        }
        Node currNode = tail.next;
        for (int i = 1; i <= size; i++) {
            if (currNode.data == data) {
                return true;
            }
            currNode = currNode.next;
        }
        return false;
    }

    public void display() {
        if (isEmpty()) {
            System.err.println("List is empty");
        } else {
            Node currNode = tail.next;
            while (currNode != tail) {
                System.out.print(currNode.data + " ");
                currNode = currNode.next;
            }
            System.out.print(currNode.data + " ");
            System.out.println();
        }

    }

    @Override
    public Iterator<Integer> iterator() {
        return new CLLIterator();
    }

    private class CLLIterator implements Iterator<Integer> {

        private Node currNode;
        private boolean visitAgain = false;

        CLLIterator() {
            if (!isEmpty())
                currNode = tail.next;
        }

        @Override
        public boolean hasNext() {
            if (isEmpty() || currNode == tail.next && visitAgain) {
                return false;
            }
            return true;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            visitAgain = true;
            int data = currNode.data;
            currNode = currNode.next;
            return data;
        }

    }

}
