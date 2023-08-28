package dataStrcutures.stack;

import dataStrcutures.list.SingleLinkedList;

public class ListStack {
    
    SingleLinkedList list;

    public ListStack(){
        list = new SingleLinkedList();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void clear(){
        list.clear();
    }

    public void push(int data){
        list.addLast(data);
    }

    public int pop(){
        int data =  list.get(list.size());
        list.removeLast();
        return data;
    }

    public int peek(){
        return list.get(list.size());
    }

    public void display(){
        list.display(); 
    }
}
