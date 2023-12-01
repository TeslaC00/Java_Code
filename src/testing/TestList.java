package testing;

import java.util.Arrays;

import dataStrcutures.list.*;
import dataStrcutures.queue.*;
import dataStrcutures.stack.*;

class TestList {
    public static void main(String[] args) {
        doublyListTest();
    }

    static void doubleEndedQueueTest() {
        DoubleEndedQueue queue = new DoubleEndedQueue();
        queue.enqueueFront(1);
        queue.enqueueRear(20);
        queue.enqueueFront(10);
        queue.enqueueRear(2);
        queue.display();
        queue.dequeueFront();
        queue.display();
        queue.dequeueRear();
        queue.display();
        queue.dequeueFront();
        queue.display();
        System.out.println("Peek: "+queue.peek());
        queue.dequeueRear();
        queue.display();
    }

    static void circularQueueTest() {
        CircularQueue queue = new CircularQueue(3);
        queue.enqueue(1);
        queue.enqueue(22);
        queue.enqueue(3);
        queue.display();
        queue.dequeue();
        queue.display();
    }

    static void arrayQueueTest() {
        ArrayQueue queue = new ArrayQueue(3);
        queue.enqueue(0);
        queue.enqueue(5);
        queue.enqueue(10);
        queue.display();
        queue.enqueue(10);
        queue.dequeue();
        queue.display();
    }

    static void doublyCircularListTest() {
        CircularDoublyLinkedList<Integer> list = new CircularDoublyLinkedList<Integer>();
        list.addFirst(1);
        list.addLast(55);
        list.addLast(44);
        list.addFirst(100);
        list.display();
        list.removeFirst();
        list.display();
        list.removeLast();
        list.display();
        list.addMid(2, 0);
        list.addMid(3, 3);
        list.display();
        list.addMid(2, 10);
        list.display();
        list.removeMid(list.size());
        list.display();
        list.removeMid(1);
        list.set(2, 99);
        list.removeValue(99);
        list.display();
        System.out.println(list.get(2));
        System.out.println(list.contains(0));
        System.out.println(list.indexOf(-5));
        System.out.println(list);
    }

    static void arrayStackTest() {
        ArrayStack stack = new ArrayStack();
        stack.push(11);
        stack.push(22);
        stack.push(3);
        stack.push(24);
        stack.display();
        stack.pop();
        stack.display();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.pop());
    }

    static void listStackTest() {
        ListStack<Integer> stack = new ListStack<Integer>();
        stack.push(4);
        stack.push(34);
        stack.push(3);
        stack.pop();
        stack.display();
        stack.addAll(Arrays.asList(1, 2, 3, 4, 5, 6), true);
        stack.display();
    }

    static void circularLinkedTest() {
        CircularLinkedList<Integer> list = new CircularLinkedList<Integer>();
        list.addFirst(3);
        list.display();
        list.addLast(999);
        list.display();
        list.addFirst(23);
        list.display();
        list.addMid(3, 24202);
        list.display();
        list.removeFirst();
        list.display();
        System.out.println(list.contains(99));
        list.set(2, 1);
        list.display();
        System.out.println(list.get(2));
        list.removeValue(99);
        list.display();
        System.out.println(list.indexOf(3));
    }

    static void singleListTest() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        Integer[] arr = { 1, 2, 3, 4, 5 };
        list.addAll(Arrays.asList(arr), true);
        list.display();
        list.addLast(5);
        list.display();
        list.addFirst(1);
        list.display();
        list.addMid(2, 0);
        list.display();
        list.removeMid(list.size());
        list.display();
        list.reverse();
        list.removeLast();
        list.display();
        list.addLast(6);
        list.set(2, 54);
        list.display();
        System.out.println("Size: " + list.size());
        System.out.println(list.toString());
        System.out.println(list.toString().length());
        System.out.println(list.indexOf(54));
        list.removeValue(54);
        for(Integer i: list){
            System.out.print(i+" ");
        }
        System.out.println("\nSize: " + list.size());
        list.removeValue(3444);
        System.out.println(list.contains(10));
        list.set(1, 111);
        list.display();
        System.out.println(list);
    }

    static void doublyListTest() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        list.addLast(4);
        list.display();
        list.addFirst(5);
        list.display();
        list.addLast(42);
        list.display();
        list.addMid(list.size(), 36);
        list.display();
        list.removeFirst();
        list.display();
        list.removeMid(3);
        list.display();
        System.out.println(list.contains(42));
        System.out.println(list.indexOf(42));
        System.out.println(list.contains(4));
        System.out.println(list.indexOf(4));
        list.set(1, 100);
        list.display();
        System.out.println(list.get(2));
        list.removeValue(100);
        list.removeValue(0);
        list.display();
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        list.removeFirst();
        System.out.println(list);
        DoublyLinkedList<Integer> list2 = new DoublyLinkedList<>();
        Integer[] arr = { 1, 2, 3, 4 };
        list2.addAll(Arrays.asList(arr));
        list2.display();
    }
}