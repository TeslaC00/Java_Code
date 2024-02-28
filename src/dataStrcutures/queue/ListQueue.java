package dataStrcutures.queue;

import dataStrcutures.list.LinkedList;
import dataStrcutures.list.SingleLinkedList;

public class ListQueue<T> {

    private LinkedList<T> list;

    public ListQueue() {
        list = new SingleLinkedList<>();
    }

    public int size() {
        return list.size();
    }

    public void clear() {
        list.clear();
    }

    public T peek() {
        return list.getHead();
    }

    public void enqueue(T item) {
        list.addLast(item);
    }

    public void enqueueFirst(T item) {
        list.addFirst(item);
    }

    public void enqueueLast(T item) {
        list.addLast(item);
    }

    public T dequeue() {
        return dequeueFirst();
    }

    public T dequeueFirst() {
        T item = list.getHead();
        list.removeFirst();
        return item;
    }

    public T dequeueLast() {
        T item = list.getLast();
        list.removeLast();
        return item;
    }

    public void display() {
        list.display();
    }

}
