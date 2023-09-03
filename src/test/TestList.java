package test;

import dataStrcutures.list.*;
import dataStrcutures.stack.*;

class TestList {
    public static void main(String[] args) {
        circularLinkedTest();
    }

    static void doublyCircularListTest() {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
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
        list.removeMid(4);
        list.display();
        list.removeMid(list.size());
        list.display();
        list.removeMid(1);
        list.display();
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
        ListStack stack = new ListStack();
        long start = System.nanoTime();
        stack.push(4);
        System.out.println("Time for push is: " + (System.nanoTime() - start));
        start = System.nanoTime();
        stack.push(34);
        System.out.println("Time for push is: " + (System.nanoTime() - start));
        start = System.nanoTime();
        stack.push(3);
        System.out.println("Time for push is: " + (System.nanoTime() - start));
        start = System.nanoTime();
        stack.pop();
        System.out.println("Time for pop is: " + (System.nanoTime() - start));
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
        list.removeMid(2);
        list.display();
        list.removeLast();
        list.display();
    }

    static void singleListTest() {
        SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
        list.addLast(5);
        list.display();
        list.addFirst(1);
        list.display();
        list.addMid(2, 0);
        list.display();
        list.removeMid(list.size());
        list.display();
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
        for (Integer i : list) {
            System.out.print(i + " ");
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
    }
}