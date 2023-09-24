package dataStrcutures.stack;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

import dataStrcutures.list.SingleLinkedList;

public class ListStack<T> implements Iterable<T> {

    private SingleLinkedList<T> list;

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

    public void addAll(Collection<T> collection) {
        list.addAll(collection);
    }

    public void addAll(Collection<T> collection, boolean reverse) {
        list.addAll(collection, reverse);
    }

    public void display() {
        list.display();
    }

    @Override
    public Iterator<T> iterator() {
        return new ListStackIterator();
    }

    private class ListStackIterator implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return !isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return pop();
        }

    }
}
