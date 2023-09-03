package dataStrcutures.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

import dataStrcutures.exceptions.EmptyListException;

/*
 * addToEmpty(value)
 */

public class CircularLinkedList<T> implements Iterable<T> {

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    private Node<T> tail;
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

    public void addFirst(T data) {
        Node<T> newNode = new Node<T>(data);
        if (isEmpty()) {
            tail = newNode;
            newNode.setNext(tail);
            size++;
        } else {
            newNode.setNext(tail.getNext());
            tail.setNext(newNode);
            size++;
        }
    }

    /** Index starts from 1 */
    public void addMid(int index, T data) {
        if (isEmpty())
            throw new EmptyListException();

        if (index < 1 || index > size)
            throw new IndexOutOfBoundsException("Index out of bound");

        if (index == 1) {
            addFirst(data);
            return;
        }
        Node<T> currentNode = tail.getNext();
        for (int i = 1; i < index - 1; i++) {
            currentNode = currentNode.getNext();
        }
        Node<T> newNode = new Node<T>(data);
        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);
        size++;

    }

    public void addLast(T data) {
        addFirst(data);
        tail = tail.getNext();
    }

    public void removeFirst() {
        if (isEmpty())
            throw new EmptyListException();

        if (size == 1) {
            clear();
            return;
        }
        tail.setNext(tail.getNext().getNext());
        size--;

    }

    /** Index starts from 1 */
    public void removeMid(int index) {
        if (isEmpty())
            throw new EmptyListException();

        if (index < 1 || index > size)
            throw new IndexOutOfBoundsException("Index out of bound");

        if (index == 1) {
            removeFirst();
            return;
        }
        if (index == size) {
            removeLast();
            return;
        }
        Node<T> currentNode = tail.getNext();
        for (int i = 1; i < index - 1; i++) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(currentNode.getNext().getNext());
        size--;

    }

    public void removeLast() {
        if (isEmpty()) {
            throw new EmptyListException();
        }
        if (size == 1) {
            clear();
            return;
        }
        Node<T> currentNode = tail.getNext();
        while (currentNode.getNext() != tail) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(tail.getNext());
        tail = currentNode;
        size--;

    }

    public boolean contains(T data) {
        if (isEmpty())
            throw new EmptyListException();

        Node<T> currentNode = tail.getNext();
        for (int i = 1; i <= size; i++) {
            if (currentNode.getData() == data) {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    /** Index starts from 1 */
    public void set(int index, T data) {
        if (isEmpty())
            throw new EmptyListException();
        if (index < 1 || index > size)
            throw new IndexOutOfBoundsException("Index out of bound");
        Node<T> currentNode = tail.getNext();
        for (int i = 1; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        currentNode.setData(data);
    }

    /** Index starts from 1 */
    public T get(int index) {
        if (isEmpty())
            throw new EmptyListException();
        if (index < 1 || index > size)
            throw new IndexOutOfBoundsException("Index out of bound");
        Node<T> currentNode = tail.getNext();
        for (int i = 1; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getData();
    }

    /** Index starts from 1 */
    public int indexOf(T data) {
        if (isEmpty())
            throw new EmptyListException();

        int index = 1;
        Node<T> currentNode = tail.getNext();
        do {
            if (currentNode.getData() == data) {
                return index;
            }
            currentNode = currentNode.getNext();
            index++;
        } while (currentNode != tail.getNext());
        return -1;
    }

    public void removeValue(T data) {
        if (isEmpty())
            throw new EmptyListException();
        if (tail.getData() == data) {
            removeLast();
            return;
        }
        Node<T> currentNode = tail;
        do {
            if (currentNode.getData() == data) {
                currentNode.setNext(currentNode.getNext().getNext());
                size--;
            }
            currentNode = currentNode.getNext();
        } while (currentNode != tail);
    }

    /** Elements are seperated by space */
    @Override
    public String toString() {
        if (isEmpty())
            return "";

        StringBuilder strBuilder = new StringBuilder();
        for (T data : this) {
            strBuilder.append(data + " ");
        }
        return strBuilder.toString();
    }

    public void display() {
        if (isEmpty())
            throw new EmptyListException();

        for (T data : this) {
            System.out.print(data + " ");
        }
        System.out.println();

    }

    @Override
    public Iterator<T> iterator() {
        return new CLLIterator();
    }

    private class CLLIterator implements Iterator<T> {

        private Node<T> currentNode;
        private boolean visitAgain = false;

        CLLIterator() {
            if (!isEmpty())
                currentNode = tail.getNext();
        }

        @Override
        public boolean hasNext() {
            return (!isEmpty() ^ (currentNode == tail.getNext() && visitAgain));
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            visitAgain = true;
            T data = currentNode.getData();
            currentNode = currentNode.getNext();
            return data;
        }

    }

}
