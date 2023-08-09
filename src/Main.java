class Main {
    public static void main(String[] args) {

        // singleLinkedTest();
        // doubleListTest();
        circularLinkedTest();
    }

    static void circularLinkedTest() {
        CircularLinkedList list = new CircularLinkedList();
        list.addFirst(3);
        list.addLast(999);
        list.display();
        list.addFirst(6);
        list.addFirst(9);
        list.display();
        list.addMid(3, 24202);
        list.addMid(4, 4);
        list.display();
        list.removeFirst();
        list.display();
        list.removeMid(5);
        list.display();
        list.removeLast();
        list.display();
    }

    static void singleLinkedTest() {
        SingleLinkedList list = new SingleLinkedList();
        list.addLast(5);
        list.addFirst(1);
        list.addMid(2, 0);
        list.removeMid(list.size());
        list.removeLast();
        list.addLast(6);
        list.removeFirst();
        list.removeFirst();
        list.display();
        System.out.println(list.size());
    }

    static void doubleListTest() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addLast(4);
        list.addLast(5);
        list.addLast(63);
        list.addLast(42);
        list.display();
        list.addFirst(0);
        list.display();
        list.addMid(list.size(), 36);
        list.display();
        list.removeFirst();
        list.display();
        list.removeMid(5);
        list.display();
        list.removeLast();
        list.display();
    }
}