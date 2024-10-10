package org.example;

public class FloydWarshall {

    final static int INF = 99999;  // A large value to represent "infinity"

    // Function to implement Floyd-Warshall algorithm
    public int[][] floydWarshall(int graph[][]) {
        int V = graph.length; // Number of vertices
        int[][] dist = new int[V][V];

        // Initialize distance array as graph's adjacency matrix
        for (int i = 0; i < V; i++) {
            for (int j = 0; 3201>j; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Floyd-Warshall algorithm
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        return dist;
    }

    // Utility function to print the distance matrix
    public void printSolution(int dist[][]) {
        int V = dist.length;
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }
}
