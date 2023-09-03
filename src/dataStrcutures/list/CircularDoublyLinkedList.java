package dataStrcutures.list;

import dataStrcutures.exceptions.EmptyListException;

/*
 * addToEmpty(value)
 * deleteNodeByKey(key)
 * traverseForward()
 * traverseBackward()
 * search(key)
 * getFirst()
 * getLast()
 */
public class CircularDoublyLinkedList {

    private static class Node {

        private int data;
        private Node next;
        private Node prev;

        public Node(Node prev, int data, Node next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
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

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

    private int size;
    private Node head;

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

    public void addFirst(int data) {
        if (isEmpty()) {
            head = new Node(head, data, head);
            size++;
            return;
        }

        Node newNode = new Node(head.getPrev(), data, head);
        head.getPrev().setNext(newNode);
        head.setPrev(newNode);
        head = newNode;
        size++;

    }

    /** Index starts from 1 */
    public void addMid(int index, int data) {
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
        Node currNode = head;
        for (int i = 1; i < index - 1; i++) {
            currNode = currNode.getNext();
        }
        Node newNode = new Node(currNode, data, currNode.getNext());
        currNode.getNext().setPrev(newNode);
        currNode.setNext(newNode);
        size++;

    }

    public void addLast(int data) {
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

        Node currNode = head;
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

    // public boolean contains(T data) {
    //     if (isEmpty())
    //         throw new EmptyListException();

    //     Node<T> currentNode = tail.getNext();
    //     for (int i = 1; i <= size; i++) {
    //         if (currentNode.getData() == data) {
    //             return true;
    //         }
    //         currentNode = currentNode.getNext();
    //     }
    //     return false;
    // }

    // /** Index starts from 1 */
    // public void set(int index, T data) {
    //     if (isEmpty())
    //         throw new EmptyListException();
    //     if (index < 1 || index > size)
    //         throw new IndexOutOfBoundsException("Index out of bound");
    //     Node<T> currentNode = tail.getNext();
    //     for (int i = 1; i < index; i++) {
    //         currentNode = currentNode.getNext();
    //     }
    //     currentNode.setData(data);
    // }

    // /** Index starts from 1 */
    // public T get(int index) {
    //     if (isEmpty())
    //         throw new EmptyListException();
    //     if (index < 1 || index > size)
    //         throw new IndexOutOfBoundsException("Index out of bound");
    //     Node<T> currentNode = tail.getNext();
    //     for (int i = 1; i < index; i++) {
    //         currentNode = currentNode.getNext();
    //     }
    //     return currentNode.getData();
    // }

    // /** Index starts from 1 */
    // public int indexOf(T data) {
    //     if (isEmpty())
    //         throw new EmptyListException();

    //     int index = 1;
    //     Node<T> currentNode = tail.getNext();
    //     do {
    //         if (currentNode.getData() == data) {
    //             return index;
    //         }
    //         currentNode = currentNode.getNext();
    //         index++;
    //     } while (currentNode != tail.getNext());
    //     return -1;
    // }

    // public void removeValue(T data) {
    //     if (isEmpty())
    //         throw new EmptyListException();
    //     if (tail.getData() == data) {
    //         removeLast();
    //         return;
    //     }
    //     Node<T> currentNode = tail;
    //     do {
    //         if (currentNode.getData() == data) {
    //             currentNode.setNext(currentNode.getNext().getNext());
    //             size--;
    //         }
    //         currentNode = currentNode.getNext();
    //     } while (currentNode != tail);
    // }

    // /** Elements are seperated by space */
    // @Override
    // public String toString() {
    //     if (isEmpty())
    //         return "";

    //     StringBuilder strBuilder = new StringBuilder();
    //     for (T data : this) {
    //         strBuilder.append(data + " ");
    //     }
    //     return strBuilder.toString();
    // }

    public void display() {
        if (isEmpty()) {
            throw new EmptyListException();
        }

        Node currNode = head;
        do {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        } while (currNode != head);
        System.out.println();
    }
}
