package dataStrcutures.queue;

public class CircularQueue {
    private final static int DEFAULT_SIZE = 16;
    private int maxSize, front, rear;
    private int[] array;

    public CircularQueue() {
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
        front = rear = -1;
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public void enqueue(int item) {
        if (isEmpty()) {
            front = 0;
            rear=0;
        }
        if ((rear+1)-front==0 && !isEmpty()) {
            System.err.println("Queue overflow");
            return;
        }
        array[(rear++) % maxSize] = item;

    }

    public void dequeue() {
        if (isEmpty()) {
            System.err.println("Queue underflow");
            return;
        }
        if (front % rear == 0) {
            front = rear = -1;
        } else {
            front++;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.err.println("Queue is empty");
            return;
        }
        for (int index = front; index<(Math.abs(front-rear))-maxSize; index=(index+1)%maxSize) {
            System.out.print(array[index] + " ");
        }
        System.out.println();

    }

}
