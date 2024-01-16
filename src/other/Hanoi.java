package other;
import java.util.Arrays;

import dataStrcutures.stack.ListStack;

public class Hanoi {
    public static void main(String[] args) {
        ListStack<Integer> src = new ListStack<>(), help = new ListStack<>(), dst = new ListStack<>();
        src.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println("Source before transferring: ");
        src.display();
        hanoi(src.size(), src, help, dst);
        System.out.println("Destination after transferring:");
        dst.display();
    }

    private static void hanoi(int size, ListStack<Integer> src, ListStack<Integer> help, ListStack<Integer> dst) {
        if (size == 1) {
            dst.push(src.pop());
            return;
        }
        hanoi(size - 1, src, dst, help);
        dst.push(src.pop());
        hanoi(size - 1, help, src, dst);
    }
}
