class Main{
    public static void main(String[] args) {
        DoublyList list  = new DoublyList();
        list.addLast(4);
        list.addLast(5);
        list.addLast(63);
        list.addLast(42);
        list.display();
        list.addFirst(0);
        list.display();
        list.addMid(4, 36);
        list.display();
        list.removeFirst();
        list.display();
        list.removeMid(3);
        list.display();
        list.removeLast();
        list.display();
    }
}