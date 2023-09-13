package dataStrcutures.stack;

public class ArrayStack {

    private final static int DEFAULT_SIZE = 16;
    private int array[];
    private int maxSize;
    private int top;

    public ArrayStack() {
        this(DEFAULT_SIZE);
    }

    public ArrayStack(int size) {
        maxSize = size;
        array = new int[maxSize];
        top = -1;
    }

    public boolean isFull() {
        return top == maxSize-1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int data) {
        if (top == maxSize) {
            return;
        }
        array[++top] = data;
    }

    public int pop() {
        if (top == -1) {
            return Integer.MIN_VALUE;
        }
        return array[top--];
    }

    public int peek() {
        return array[top];
    }

    public void clear() {
        array = new int[maxSize];
        top = -1;
    }

    public void display() {
        if (isEmpty()) {
            System.err.println("List is empty");
            return;
        }
        for (int i = 0; i <= top; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
