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

    private Node head;
    private int size;

    public DoublyList() {
        head = null;
        size = 0;
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return head == null;
    }

    void addFirst(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            size++;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    /** Index starts from 1 */
    void addMid(int index, int data) {
        if (index == 1) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else if (index > 1 && index < size) {
            Node newnNode = new Node(data);
            Node temp = head;
            int counter = 2;
            while (temp.next != null) {
                if(counter == index){
                    newnNode.next = temp.next;
                    newnNode.prev = temp;
                    temp.next.prev = newnNode;
                    temp.next = newnNode;
                    size++;
                    break;
                } else{
                    temp = temp.next;
                    counter++;
                }
            }
        } else {
            System.out.println("Index not found");
        }
    }

    void addLast(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            size++;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
            size++;
        }
    }

    void removeFirst(){
        if(!isEmpty()){
            head.next.prev = null;
            head = head.next;
            size--;
        }
    }

    void removeMid(int index){
        if(index == 1){ removeFirst();}
        else if( index == size){ removeLast();}
        else if( index >1 && index <size){
            int counter = 2;
            Node temp = head;
            while(temp.next != null){
                if(index == counter){
                    temp.next.next.prev = temp;
                    temp.next = temp.next.next;
                    size--;
                    break;
                }
                else{
                    temp = temp.next;
                    counter++;
                }
            }
        }
        else{
            System.out.println("Index not found");
        }
    }

    void removeLast() {
        if(!isEmpty()){
            Node temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }
            temp.next = null;
            size--;
        }
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

}
