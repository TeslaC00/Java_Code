package ADA;

public class Prims {
    // Prims algorithm
    // choose a starting index
    // add connecting edges to it to the queue
    // pop the first edge
    // add poped edge connecting edges to the queue
    // repeat untill all vertices are included

    // define a parent array to store vertex at i and the value is the parent of
    // this node
    // define a key array that stores the distance to that vertex from the parent
    // sort the arrays
    public void mst(int[][] graph) {
        int v = graph.length; // length of vertices
        int[] parent = new int[v]; // parent of i vertex
        int[] distance = new int[v]; // distance of the v
        boolean[] mstSet = new boolean[v]; // boolean array to track which vertex is added to the MST

        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        // initialize initial values
        parent[0] = -1; // parent of starting vertex is -1
        distance[0] = 0; // distance of first vertex is 0

        // i guess we looping for v-1 edges
        for (int i = 0; i < v - 1; i++) {
            int u = minIndex(mstSet, distance, v);
            // add min index in mstSet
            mstSet[u] = true;
            for (int j = 0; j < v; j++) {
                
                if (mstSet[j] == false  // check if the vertex is not in mst index
                        && graph[u][j] != 0 // check if the distance is not equal to 0
                        && graph[u][j] < distance[j]) { // check if the distance of the vertex from parent u is less than the previous distance
                    parent[j] = u;
                    distance[j] = graph[u][j];
                }
            }
        }
        printMst(parent, distance, v);
    }

    private int minIndex(boolean[] mstSet, int[] distance, int v) {
        int minIndex = -1, minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < v; i++) {
            if (mstSet[i] == false && distance[i] < minDistance) {
                minIndex = i;
                minDistance = distance[i];
            }
        }
        return minIndex; // index of the minimum distance vertex that is not in MST
    }

    public void printMst(int[] parent, int[] distance, int v){
        System.out.println("Parent:\tVertex:\tDistance");
        for (int i = 0; i < v; i++) {
            System.out.println(parent[i]+"\t"+i+"\t"+distance[i]);
        }
    }
}
