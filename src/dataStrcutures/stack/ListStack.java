package dataStrcutures.stack;

import dataStrcutures.list.SingleLinkedList;

public class ListStack<T> {

    SingleLinkedList<T> list;

    public ListStack() {
        list = new SingleLinkedList<T>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void clear() {
        list.clear();
    }

    public void push(T data) {
        list.addFirst(data);
    }

    public T pop() {
        T data = list.getHead();
        list.removeFirst();
        return data;
    }

    public T peek() {
        return list.getHead();
    }

    public void display() {
        list.display();
    }
}
