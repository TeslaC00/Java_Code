package dataStrcutures.stack;

import dataStrcutures.list.SingleLinkedList;

public class ListStack {

    SingleLinkedList list;

    public ListStack() {
        list = new SingleLinkedList();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void clear() {
        list.clear();
    }

    public void push(int data) {
        list.addFirst(data);
    }

    public int pop() {
        int data = list.get(1);
        list.removeFirst();
        return data;
    }

    public int peek() {
        return list.get(1);
    }

    public void display() {
        list.display();
    }
}
