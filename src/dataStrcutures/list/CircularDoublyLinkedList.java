package dataStrcutures.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

import dataStrcutures.exceptions.EmptyListException;

// TODO: Change indexing to 0 based

public class CircularDoublyLinkedList<T> implements Iterable<T>, LinkedList<T> {

    private static class Node<T> {

        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
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

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }
    }

    private int size;
    private Node<T> head;

    public CircularDoublyLinkedList() {
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
        Node<T> newNode = new Node<T>(data);
        if (isEmpty()) {
            newNode.setNext(newNode);
            newNode.setPrev(newNode);
            head = newNode;
            size++;
            return;
        }
        newNode.setNext(head);
        newNode.setPrev(head.getPrev());
        head.getPrev().setNext(newNode);
        head.setPrev(newNode);
        head = newNode;
        size++;

    }

    /** Index starts from 1 */
    public void addMid(int index, T data) {
        if (isEmpty()) {
            throw new EmptyListException();
        }

        if (index < 1 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }

        if (index == 1) {
            addFirst(data);
            return;
        }
        Node<T> currNode = head;
        for (int i = 1; i < index - 1; i++) {
            currNode = currNode.getNext();
        }
        Node<T> newNode = new Node<T>(data);
        newNode.setPrev(currNode);
        newNode.setNext(currNode.getNext());
        currNode.getNext().setPrev(newNode);
        currNode.setNext(newNode);
        size++;

    }

    public void addLast(T data) {
        addFirst(data);
        if (!isEmpty())
            head = head.getNext();

    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new EmptyListException();
        }

        if (size == 1) {
            clear();
            return;
        }

        head.getPrev().setNext(head.getNext());
        head.getNext().setPrev(head.getPrev());
        head = head.getNext();
        size--;

    }

    public void removeMid(int index) {
        if (isEmpty()) {
            throw new EmptyListException();
        }

        if (index < 1 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }

        if (index == 1) {
            removeFirst();
            return;
        }

        Node<T> currNode = head;
        for (int i = 1; i < index - 1; i++) {
            currNode = currNode.getNext();
        }
        currNode.getNext().getNext().setPrev(currNode);
        currNode.setNext(currNode.getNext().getNext());
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

        head.getPrev().getPrev().setNext(head);
        head.setPrev(head.getPrev().getPrev());
        size--;
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

    public boolean contains(T data) {
        if (isEmpty())
            throw new EmptyListException();

        // Node<T> currentNode = tail.getNext();
        // for (int i = 1; i <= size; i++) {
        // if (currentNode.getData() == data) {
        // return true;
        // }
        // currentNode = currentNode.getNext();
        // }
        return indexOf(data) != -1;
    }

    /** Index starts from 1 */
    public void set(int index, T data) {
        if (isEmpty())
            throw new EmptyListException();
        if (index < 1 || index > size)
            throw new IndexOutOfBoundsException("Index out of bound");
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
            throw new IndexOutOfBoundsException("Index out of bound");
        Node<T> currentNode = head;
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
        Node<T> currentNode = head;
        do {
            if (currentNode.getData() == data) {
                return index;
            }
            currentNode = currentNode.getNext();
            index++;
        } while (currentNode != head);
        return -1;
    }

    public void removeValue(T data) {
        if (isEmpty())
            throw new EmptyListException();
        if (head.getData() == data) {
            removeFirst();
            return;
        }
        if (head.getPrev().getData() == data) {
            removeLast();
            return;
        }
        Node<T> currentNode = head;
        do {
            if (currentNode.getNext().getData() == data) {
                currentNode.setNext(currentNode.getNext().getNext());
                currentNode.getNext().getNext().setPrev(currentNode);
                size--;
            }
            currentNode = currentNode.getNext();
        } while (currentNode != head);
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
        if (isEmpty()) {
            throw new EmptyListException();
        }
        for (T data : this) {
            System.out.print(data + " ");
        }
        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {
        return new CircularDoublyListIterator();
    }

    private class CircularDoublyListIterator implements Iterator<T> {

        private Node<T> currentNode;
        private boolean visited = false;

        public CircularDoublyListIterator() {
            if (!isEmpty()) {
                currentNode = head;
            }
        }

        @Override
        public boolean hasNext() {
            return (!isEmpty() ^ (currentNode == head && visited));
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            visited = true;
            T data = currentNode.getData();
            currentNode = currentNode.getNext();
            return data;
        }

    }

    @Override
    public T getHead() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T getLast() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void reverse() {
        // TODO Auto-generated method stub
        
    }
}
