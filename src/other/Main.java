package other;

public class Main {
    /**
     * 34 44 54 64
     * 82 108 134 160
     * 34 44 54 64
     * 82 108 134 160
     */
    public static void main(String[] args) {
        int[][] matrix = {  { 1, 2, 3, 4 },
                            { 5, 6, 7, 8 },
                            { 1, 2, 3, 4 },
                             };
        Matrix m = new Matrix(matrix);
        m.strassenMultiply(m).display();
    }
}
