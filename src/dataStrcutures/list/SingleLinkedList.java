package dataStrcutures.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

import dataStrcutures.exceptions.EmptyListException;

public class SingleLinkedList<T> implements Iterable<T> {

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

    public void addFirst(T data) {
        Node<T> newNode = new Node<T>(data, head);
        head = newNode;
        size++;
    }

    /** Index starts from 1 */
    public void addMid(int index, T data) {
        if (isEmpty())
            throw new EmptyListException();

        if (index < 1 || index > size + 1)
            throw new IndexOutOfBoundsException("Index is out of bound");

        if (index == 1)
            addFirst(data);

        else if (index == size)
            addLast(data);

        else {
            Node<T> currentNode = head;
            for (int i = 1; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }
            Node<T> newNode = new Node<T>(data, currentNode.getNext());
            currentNode.setNext(newNode);
            size++;
        }
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<T>(data, null);
        if (isEmpty()) {
            head = newNode;
        } else {
            // Node lastNode = head;
            // while (lastNode.getNext() != null) {
            // lastNode = lastNode.getNext();
            // }
            Node<T> currentNode, nextNode;
            for (currentNode = head; (nextNode = currentNode.getNext()) != null; currentNode = nextNode)
                ;
            currentNode.setNext(newNode);
        }
        size++;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new EmptyListException();

        head = head.getNext();
        size--;
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
            Node<T> currentNode = head;
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
            Node<T> currentNode = head;
            while (currentNode.getNext().getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(null);
            size--;
        }
    }

    public void addAll(Collection<T> collection) {
        addAll(collection, false);
    }

    public void addAll(Collection<T> collection, boolean reverse) {
        for (T data : collection) {
            if (reverse)
                addFirst(data);
            else
                addLast(data);
        }
    }

    public T get(int index) {
        if (isEmpty())
            throw new EmptyListException();
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bound");
        }
        Node<T> currentNode = head;
        for (int i = 1; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getData();
    }

    public T getHead() {
        if (!isEmpty())
            return head.data;
        return null;
    }

    public void removeValue(T data) {
        if (isEmpty())
            throw new EmptyListException();
        if (head.getData() == data) {
            removeFirst();
            return;
        }
        Node<T> currentNode = head;
        while (currentNode.getNext() != null) {
            if (currentNode.getNext().getData() == data) {
                currentNode.setNext(currentNode.getNext().getNext());
                size--;
                return;
            }
            currentNode = currentNode.getNext();
        }

    }

    public boolean contains(T data) {
        if (isEmpty())
            throw new EmptyListException();

        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.getData() == data)
                return true;
            currentNode = currentNode.getNext();
        }
        return false;
    }

    public int indexOf(T data) {
        if (isEmpty())
            throw new EmptyListException();

        Node<T> currentNode = head;
        int index = 1;
        while (currentNode != null) {
            if (currentNode.getData() == data)
                return index;
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

    public void display() {
        if (isEmpty())
            throw new EmptyListException();
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
