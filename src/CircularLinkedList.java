public class CircularLinkedList {
    private static class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data = data;
            next = null;
        }
    }

    private Node head;
    private int size;

    public int getSize() {
        return size;
    }

    public CircularLinkedList(){
        head = null;
        size = 0;
    }

    public boolean isEmpty(){
        return head==null;
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            head = newNode;
            newNode.next = head;
            size++;
        }
        else{
            Node temp = head;
            while(temp.next != head){
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    public void display(){
        Node temp = head;
        while(temp.next != head){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}
