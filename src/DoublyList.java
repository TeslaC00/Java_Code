public class DoublyList {
    private static class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }

    Node head;
    int size;

    public DoublyList() {
        head = null;
        size = 0;
    }

    int size() {
        return size;
    }

    boolean isEmpty(){ return head==null;}

    void add(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            head = newNode;
            size++;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
        size++;
    }

    void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

}
