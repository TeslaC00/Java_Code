import dataStrcutures.list.*;
import dataStrcutures.stack.*;

class Main {
    public static void main(String[] args) {
        doublyCircularListTest();
    }

    static void doublyCircularListTest(){
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
    }

    static void circularLinkedTest() {
        CircularLinkedList list = new CircularLinkedList();
        list.addFirst(3);
        list.display();
        list.addLast(999);
        list.display();
        list.addFirst(6);
        list.display();
        list.addFirst(9);
        list.display();
        list.addMid(3, 24202);
        list.display();
        list.addMid(4, 4);
        list.display();
        list.removeFirst();
        list.display();
        list.removeMid(2);
        list.display();
        list.removeLast();
        list.display();
    }

    static void singleLinkedTest() {
        SingleLinkedList list = new SingleLinkedList();
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
        list.removeValue(54);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println("\nSize: " + list.size());
        System.out.println(list.contains(1));
    }

    static void doubleListTest() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addLast(4);
        list.display();
        list.addFirst(5);
        list.display();
        list.addLast(63);
        list.display();
        list.addLast(42);
        list.display();
        list.addFirst(0);
        list.display();
        list.addMid(list.size(), 36);
        list.display();
        list.removeFirst();
        list.display();
        list.removeMid(3);
        list.display();
        list.removeLast();
        list.display();
    }
}