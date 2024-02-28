package dataStrcutures.queue;

public class DoubleEndedQueue {

    private static final int DEFAULT_SIZE = 16;
    private int front, rear, maxSize;
    private int[] array;

    public DoubleEndedQueue() {
        this(DEFAULT_SIZE);
    }

    public DoubleEndedQueue(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
        front = rear = -1;
    }

    public boolean isEmpty() {
        return (front == -1);
    }

    public boolean isFull() {
        return (front == 0 && rear == maxSize - 1) || (rear + 1 == front);
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return Integer.MAX_VALUE;
        }
        return array[front];
    }

    public void enqueueFront(int item) {
        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }
        if (isEmpty()) {
            front = rear = 0;
            array[front] = item;
            return;
        }
        if (front == 0)
            front = maxSize;
        array[--front] = item;
    }

    public void enqueueRear(int item) {
        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }
        if (isEmpty()) {
            front = rear = 0;
            array[rear] = item;
            return;
        }
        if (rear == maxSize - 1)
            rear = -1;
        array[++rear] = item;
    }

    public int dequeueFront() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return Integer.MAX_VALUE;
        }
        if (front == rear) {
            int item = array[rear];
            front = rear = -1;
            return item;
        }
        if (front == maxSize - 1) {
            front = 0;
            return array[maxSize - 1];
        }
        return array[front++];
    }

    public int dequeueRear() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return Integer.MAX_VALUE;
        }
        if (front == rear) {
            int item = array[front];
            front = rear = -1;
            return item;
        }
        if (rear == 0) {
            rear = maxSize - 1;
            return array[0];
        }
        return array[rear--];
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
