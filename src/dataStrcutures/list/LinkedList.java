package dataStrcutures.list;

import java.util.Collection;

public interface LinkedList<T> {

    int size();

    boolean isEmpty();

    void clear();

    void addFirst(T data);

    void addMid(int index, T data);

    void addLast(T data);

    void removeFirst();

    void removeMid(int index);

    void removeLast();

    // TODO: Change method to work with non-empty list
    void addAll(Collection<T> collection);

    void addAll(Collection<T> collection, boolean reverse);

    T get(int index);

    T getHead();

    T getLast();

    void removeValue(T data);

    boolean contains(T data);

    int indexOf(T data);

    /** Index starts from 1 */
    void set(int index, T data);

    void reverse();

    /** Elements are seperated by space in the string returned */
    String toString();

    void display();

}