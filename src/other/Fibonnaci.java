package other;

import java.util.ArrayList;

public class Fibonnaci {

    // Proper bullshite approach
    static long getFib(int num) {
        if (num == 0)
            return 0;
        if (num == 1)
            return 1;

        return getFib(num - 1) + getFib(num - 2);
    }

    static ArrayList<Long> cache = new ArrayList<>(100);
    static double cacheMiss = 0, functionCount = 0;

    // Fine but has a lot recursion
    static long getFibV2(int num) {
        functionCount++;
        if (num >= cache.size()) {
            cache.add(getFibV2(num - 1) + getFibV2(num - 2));
            cacheMiss++;
        }

        return cache.get(num);
    }

    // How is this so godly fast with just looping for same values
    static long getFibV3(int num) {
        long a = 0, b = 1;
        for (int i = 2; i <= num; i++) {
            long temp = a + b;
            b = a;
            a = temp;
        }
        return b;
    }

    static void runV1(int n) {
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            // System.out.print(getFib(i) + " ");
            getFib(i);
        }
        System.out.println();
        double timeTakeInMs = (System.nanoTime() - startTime) / 1_000_000.0;
        System.out.println("Fibonacci calculated: " + n + " - Total Time Taken: " + timeTakeInMs + "ms");
    }

    static void runV2(int n) {
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            // System.out.print(getFibV2(i) + " ");
            getFibV2(i);
        }
        System.out.println();
        double timeTakeInMs = (System.nanoTime() - startTime) / 1_000_000.0;
        System.out.println("Fibonacci V2 calculated: " + n + " - Total Time Taken: " + timeTakeInMs + "ms");
        // Cache stats
        System.out.println("Function Counts: " + functionCount + " Cache Miss: " + cacheMiss + " Cache Hit: "
                + (functionCount - cacheMiss));
        double cacheMissPer = (cacheMiss * 100) / functionCount;
        System.out.println("Cache Miss: " + cacheMissPer + " Cache Hit: " + (100.0 - cacheMissPer));
    }

    static void runV3(int n) {
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            // System.out.print(getFibV3(i) + " ");
            getFibV3(i);
        }
        System.out.println();
        double timeTakeInMs = (System.nanoTime() - startTime) / 1_000_000.0;
        System.out.println("Fibonacci V3 calculated: " + n + " - Total Time Taken: " + timeTakeInMs + "ms");
    }

    public static void main(String[] args) {
        cache.add(0l);
        cache.add(1l);
        int nums = 100;
        System.out.println("Running ...");
        // runV1(nums);
        runV2(nums);
        runV3(nums);
    }
}
