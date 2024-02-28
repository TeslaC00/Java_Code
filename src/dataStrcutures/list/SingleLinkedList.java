package dataStrcutures.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

import dataStrcutures.exceptions.EmptyListException;

public class SingleLinkedList<T> implements Iterable<T>, LinkedList<T> {

    private static class Node<T> {

        private T data;
        private Node<T> next;

        private Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        private T getData() {
            return data;
        }

        private void setData(T data) {
            this.data = data;
        }

        private Node<T> getNext() {
            return next;
        }

        private void setNext(Node<T> next) {
            this.next = next;
        }

    }

    private int size;
    private Node<T> head;

    public SingleLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    private void assertEmpty() {
        if (isEmpty())
            throw new EmptyListException();
    }

    @Override
    public void addFirst(T data) {
        Node<T> newNode = new Node<T>(data, head);
        head = newNode;
        size++;
    }

    @Override
    public void addMid(int index, T data) {

        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index is out of bound");

        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == size) {
            addLast(data);
            return;
        }

        Node<T> currentNode = head;
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.getNext();
        }
        Node<T> newNode = new Node<T>(data, currentNode.getNext());
        currentNode.setNext(newNode);
        size++;
    }

    @Override
    public void addLast(T data) {
        Node<T> newNode = new Node<T>(data, null);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node<T> currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }
        size++;
    }

    @Override
    public void removeFirst() {
        assertEmpty();
        head = head.getNext();
        size--;
    }

    @Override
    public void removeMid(int index) {
        assertEmpty();

        if (index < 0 || index > size - 1)
            throw new IndexOutOfBoundsException("Index is out of bound");

        if (index == 0) {
            removeFirst();
            return;
        }

        Node<T> currentNode = head;
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(currentNode.getNext().getNext());
        size--;

    }

    @Override
    public void removeLast() {
        assertEmpty();
        if (size == 1) {
            clear();
            return;
        }
        Node<T> currentNode = head;
        while (currentNode.getNext().getNext() != null) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(null);
        size--;

    }

    @Override
    public void addAll(Collection<T> collection) {
        addAll(collection, false);
    }

    @Override
    public void addAll(Collection<T> collection, boolean reverse) {
        for (T data : collection) {
            if (reverse)
                addFirst(data);
            else
                addLast(data);
        }
    }

    @Override
    public T get(int index) {
        assertEmpty();
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Index is out of bound");
        }
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getData();
    }

    @Override
    public T getHead() {
        if (isEmpty())
            return null;
        return head.getData();
    }

    @Override
    public T getLast() {
        if (isEmpty())
            return null;
        Node<T> currentNode = head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getData();
    }

    @Override
    public void removeValue(T data) {
        assertEmpty();
        if (head.getData() == data) {
            removeFirst();
            return;
        }
        Node<T> currentNode = head;
        while (currentNode.getNext() != null) {
            if (currentNode.getNext().getData() == data) {
                currentNode.setNext(currentNode.getNext().getNext());
                size--;
            }
            currentNode = currentNode.getNext();
        }

    }

    @Override
    public boolean contains(T data) {
        return indexOf(data) >= 0;
    }

    @Override
    public int indexOf(T data) {
        assertEmpty();

        Node<T> currentNode = head;
        int index = 0;
        while (currentNode != null) {
            if (currentNode.getData().equals(data))
                return index;
            currentNode = currentNode.getNext();
            index++;
        }
        return -1;
    }

    /** Index starts from 1 */
    @Override
    public void set(int index, T data) {
        assertEmpty();
        if (index < 0 || index > size - 1)
            throw new IndexOutOfBoundsException("Index is out of bound");
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        currentNode.setData(data);
    }

    @Override
    public void reverse() {
        Node<T> prevNode = null;
        Node<T> currentNode = head;
        Node<T> nextNode = null;

        while (currentNode != null) {
            nextNode = currentNode.getNext();
            currentNode.setNext(prevNode);
            prevNode = currentNode;
            currentNode = nextNode;
        }

        head = prevNode;
    }

    /** Elements are seperated by space in the string returned */
    @Override
    public String toString() {
        if (isEmpty())
            return "";
        StringBuilder strBuilder = new StringBuilder();
        for (T i : this) {
            strBuilder.append(i + " ");
        }
        return strBuilder.toString();
    }

    @Override
    public void display() {
        assertEmpty();
        for (T i : this) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {

        private Node<T> currentNode;

        public ListIterator() {
            currentNode = head;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = currentNode.getData();
            currentNode = currentNode.getNext();
            return data;
        }

    }

}
