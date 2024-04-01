package other;

import ADA.Prims;
import helper.Display;

public class Main {
    /**
     * 34 44 54 64
     * 82 108 134 160
     * 34 44 54 64
     * 82 108 134 160
     */
    public static void main(String[] args) {
        Prims prims = new Prims();
        int[][] graph = { { 0, 2, 0, 6, 0 },
                        { 2, 0, 3, 8, 5 },
                        { 0, 3, 0, 0, 7 },
                        { 6, 8, 0, 0, 9 },
                        { 0, 5, 7, 9, 0 } };
        prims.mst(graph);
    }

    public static int[] array() {
        return new int[] { 1, 1, 2 };
    }

    public void method() {
        int[][] matrix = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 1, 2, 3, 4 },
        };
        Matrix m = new Matrix(matrix);
        // m.strassenMultiply(m).display();
        for (Matrix[] is : m.splitPadded(2, 2)) {
            for (Matrix i : is) {
                System.out.println(i);
            }
        }
    }
}
