package dataStrcutures.queue;

import dataStrcutures.list.SingleLinkedList;

public class ListQueue<T> {
    
    private SingleLinkedList<T> list;

    public ListQueue(){
        list = new SingleLinkedList<>();
    }

    public int size(){
        return list.size();
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
