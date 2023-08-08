class Main {
    public static void main(String[] args) {

        SingleLinkedList list = new SingleLinkedList();
        list.addLast(5);
        list.addFirst(1);
        list.addMid(2, 0);
        list.removeMid(list.size(),0);
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
        list.removeMid(3);
        list.display();
        list.removeLast();
        list.display();
    }
}