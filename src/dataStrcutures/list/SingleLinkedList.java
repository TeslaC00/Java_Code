package dataStrcutures.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * get(index)
 * indexOf(data)
 * reverse()
 */

public class SingleLinkedList implements Iterable<Integer> {

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
        newNode.setNext(head);
        head = newNode;
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
            Node currentNode = head;
            for (int i = 1; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
            size++;
        }
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            // Node lastNode = head;
            // while (lastNode.getNext() != null) {
            // lastNode = lastNode.getNext();
            // }
            Node currNode, nextNode;
            for (currNode = head; (nextNode = currNode.getNext()) != null; currNode = nextNode)
                ;
            currNode.setNext(newNode);
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
            Node currentNode = head;
            for (int i = 1; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(currentNode.getNext().getNext());
            size--;
        }
    }

    public void removeLast() {
        if (isEmpty())
            throw new EmptyListException();
        if (size == 1) {
            clear();
        } else {
            Node currentNode = head;
            while (currentNode.getNext().getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(null);
            size--;
        }
    }

    public void removeValue(int data) {
        if (isEmpty())
            throw new EmptyListException();
        if (head.getData() == data)
            removeFirst();
        else {
            Node currentNode = head;
            while (currentNode.getNext().getData() != data) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(currentNode.getNext().getNext());
            size--;
        }
    }

    public boolean contains(int data) {
        if (isEmpty())
            throw new EmptyListException();

        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.getData() == data)
                return true;
            currentNode = currentNode.getNext();
        }
        return false;
    }

    /** Index starts from 1 */
    public void set(int index, int data) {
        if (index < 1 || index > size)
            throw new IndexOutOfBoundsException("Index is out of bound");
        Node currentNode = head;
        for (int i = 1; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        currentNode.setData(data);
    }

    public int[] toArray() {

        if (isEmpty())
            return null;

        int arr[] = new int[size];
        Node curentNode = head;
        for (int i = 0; i < size; i++) {
            arr[i] = curentNode.getData();
            curentNode = curentNode.getNext();
        }

        return arr;
    }

    /** Elements are seperated by space in the string returned */
    public String toString() {
        if (isEmpty())
            return "";
        StringBuilder strBuilder = new StringBuilder();
        for (Integer i : this) {
            strBuilder.append(i + " ");
        }
        return strBuilder.toString();
    }

    public void display() {
        if (isEmpty())
            throw new EmptyListException();
        for (Integer i : this) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Integer> {

        private Node currentNode;

        ListIterator() {
            currentNode = head;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int data = currentNode.getData();
            currentNode = currentNode.getNext();
            return data;
        }

    }

}
