package ADA;

public class FractionalKnapsack0_1 {
    int items, capacity;
    int[] weights, profits;

    public FractionalKnapsack0_1(int items, int capacity, int[] weights, int[] profits) {
        this.items = items;
        this.capacity = capacity;
        this.weights = weights;
        this.profits = profits;
    }

    public void showMatrix() {
        int[][] matrix = init();
        for (int i = 1; i < matrix.length; i++) {
            for (int w = 1; w < matrix[i].length; w++) {
                int x=0;
                try {
                    if(weights[i - 1]<=w){
                        x = profits[i - 1] + matrix[i - 1][w - weights[i - 1]];
                    }
                } catch (IndexOutOfBoundsException e) {
                    x = 0;
                }
                matrix[i][w] = Math.max(matrix[i - 1][w], x);
            }
        }
        for (int[] i : matrix) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private int[][] init() {
        int[][] matrix = new int[items + 1][capacity + 1];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = 0;
        }
        return matrix;
    }

}
