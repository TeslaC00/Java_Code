package dataStrcutures.queue;

public class CircularQueue {

    private static final int DEFAULT_SIZE = 16;
    private int front, rear, maxSize;
    private int[] array;

    public CircularQueue() {
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
        front = rear = -1;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public int peek() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return array[front];
    }

    public void enqueue(int item) {
        if (isEmpty()) {
            front = rear = 0;
            array[rear] = item;
        } else if (isFull()) {
            System.err.println("Overflow");
        } else {
            rear = (rear + 1) % maxSize;
            array[rear] = item;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.err.println("Underflow");
            return Integer.MIN_VALUE;
        } else if (rear == front) {
            int item = array[front];
            front = rear = -1;
            return item;
        } else {
            int item = array[front];
            front = (front + 1) % maxSize;
            return item;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        for (int i = front; i != rear; i = (i + 1) % maxSize) {
            System.out.print(array[i] + " ");
        }
        System.out.print(array[rear] + "\n");
    }

}
