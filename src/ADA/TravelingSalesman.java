package ADA;

import java.util.Scanner;

/**
 * TravelingSalesman
 */
public class TravelingSalesman {

    public static int[][] inputMatrix(int nodes) {
        int[][] matrix = new int[nodes][nodes];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                System.out.println("Give distance of node " + i + " to " + j + ": ");
                matrix[i][j] = scan.nextInt();
            }
        }
        scan.close();
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println();
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    static class Node implements Comparable<Node> {
        int src, dst;
        Integer distance;

        public Node() {
        }

        public Node(int src, int dst) {
            this.src = src;
            this.dst = dst;
        }

        public Node(int src, int dst, Integer distance) {
            this.src = src;
            this.dst = dst;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return o.distance.compareTo(this.distance);
        }
    }


    public static void tsp(){}

    public static void main(String[] args) {
        // printMatrix(inputMatrix(4));
        int[][] matrix = {
                { 0, 1, 2, 3 },
                { 0, 0, 1, 2 },
                { 0, 0, 0, 1 },
                { 0, 0, 0, 0 }
        };
        // pass source and remaining nodes
        // recursive loop until you reach base case -> no remaining nodes
        // add the distance from matrix after recursion returns in the node
        for (int i = 1; i < 4; i++) {
            
        }
    }
}