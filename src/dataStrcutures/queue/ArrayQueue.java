package dataStrcutures.queue;

public class ArrayQueue {

    private static final int DEFAULT_SIZE = 16;
    private int front, rear, maxSize;
    private int[] array;

    public ArrayQueue() {
        this(DEFAULT_SIZE);
    }

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
        front = rear = -1;
    }

    public boolean isEmpty() {
        return (front == -1 && rear == -1);
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public void enqueue(int item) {
        if (isEmpty()) {
            front = rear = 0;
            array[rear] = item;
        } else if (isFull()) {
            System.err.println("Overflow");
        } else {
            array[++rear] = item;
        }
    }

    public int dequeue() {
        if (isEmpty() || front > rear) {
            System.err.println("Underflow");
            return Integer.MIN_VALUE;
        } else {
            int item = array[front++];
            return item;
        }

    }

    public void display() {
        for (int i = front; i <= rear; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
