package dataStrcutures.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

import dataStrcutures.exceptions.EmptyListException;

/*
 * iterateForward()
 * iterateBackward()
 */

public class DoublyLinkedList<T> implements Iterable<T> {

    private static class Node<T> {

        private T data;
        private Node<T> prev;
        private Node<T> next;

        private Node(Node<T> prev, T data, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        private T getData() {
            return data;
        }

        private void setData(T data) {
            this.data = data;
        }

        private Node<T> getPrev() {
            return prev;
        }

        private void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        private Node<T> getNext() {
            return next;
        }

        private void setNext(Node<T> next) {
            this.next = next;
        }
    }

    private Node<T> head;
    private Node<T> tail;
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
        return head == null && tail == null;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<T>(null, data, head);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.setPrev(newNode);
        }

        head = newNode;
        size++;
    }

    /** Index starts from 1 */
    public void addMid(int index, T data) {
        if (isEmpty())
            throw new EmptyListException();

        if (index < 1 || index > size)
            throw new IndexOutOfBoundsException("Index is out of bound");

        if (index == 1) {
            addFirst(data);
            return;
        }
        Node<T> currentNode = head;
        for (int i = 1; i < index - 1; i++) {
            currentNode = currentNode.next;
        }
        Node<T> newNode = new Node<T>(currentNode, data, currentNode.getNext());
        currentNode.getNext().setPrev(newNode);
        currentNode.setNext(newNode);
        size++;

    }

    public void addLast(T data) {
        Node<T> newNode = new Node<T>(tail, data, null);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }

        tail = newNode;
        size++;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new EmptyListException();

        if (size == 1) {
            clear();
            return;
        }
        head.getNext().setPrev(null);
        head = head.getNext();
        size--;

    }

    /** Index starts from 1 */
    public void removeMid(int index) {
        if (isEmpty())
            throw new EmptyListException();

        if (index < 1 || index > size)
            throw new IndexOutOfBoundsException("Index is out of bound");

        if (index == 1) {
            removeFirst();
            return;
        }
        if (index == size) {
            removeLast();
            return;
        }
        Node<T> currentNode = head;
        for (int i = 1; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        currentNode.getNext().setPrev(currentNode.getPrev());
        currentNode.getPrev().setNext(currentNode.getNext());
        size--;

    }

    public void removeLast() {
        if (isEmpty())
            throw new EmptyListException();

        if (size == 1) {
            clear();
            return;
        }
        tail = tail.getPrev();
        tail.setNext(null);
        size--;

    }

    public boolean contains(T data) {
        if (isEmpty())
            throw new EmptyListException();

        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.getData() == data) {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    public int indexOf(T data) {
        if (isEmpty())
            throw new EmptyListException();

        int index = 1;
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.getData() == data) {
                return index;
            }
            currentNode = currentNode.getNext();
            index++;
        }
        return -1;
    }

    /** Index starts from 1 */
    public void set(int index, T data) {
        if (isEmpty())
            throw new EmptyListException();

        if (index < 1 || index > size)
            throw new IndexOutOfBoundsException("Index is out of bound");

        Node<T> currentNode = head;
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
            throw new IndexOutOfBoundsException("Index is out of bound");

        Node<T> currentNode = head;
        for (int i = 1; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getData();
    }

    public void removeValue(T data) {
        if (isEmpty())
            throw new EmptyListException();

        if (head.getData() == data) {
            removeFirst();
            return;
        }
        if (tail.getData() == data) {
            removeLast();
            return;
        }
        Node<T> currentNode = head.getNext();
        while (currentNode != null) {
            if (currentNode.getData() == data) {
                currentNode.getPrev().setNext(currentNode.getNext());
                currentNode.getNext().setPrev(currentNode.getPrev());
                size--;
                return;
            }
            currentNode = currentNode.getNext();
        }

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
        return new DoublyListIterator();
    }

    private class DoublyListIterator implements Iterator<T> {

        Node<T> currentNode;

        public DoublyListIterator() {
            currentNode = head;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();

            T data = currentNode.getData();
            currentNode = currentNode.getNext();
            return data;
        }

    }

}
