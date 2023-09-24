package dataStrcutures.queue;

import dataStrcutures.list.CircularLinkedList;

public class ListQueue<T> {
    
    private CircularLinkedList<T> list;

    public ListQueue(){
        list = new CircularLinkedList<>();
    }

    public int size(){
        return list.getSize();
    }

    public void clear(){
        list.clear();
    }

    public T peek(){
        return list.getHead();
    }

    public void enqueue(T item){
        list.addLast(item);
    }

    public T dequeue(){
        T item = list.getHead();
        list.removeFirst();
        return item;
    }

    public void display(){
        list.display();
    }

}
