package org.example;


import java.util.*;

public class Kruskal {
    void kruskalMST() {
        Edge[] result = new Edge[V - 1];
        int e = 0;
        int i = 0;

        Arrays.sort(edges);

        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        while (e < V - 1) {
            Edge next_edge = edges[i++];

            int x = find(parent, next_edge.src);
            int y = find(parent, next_edge.dest);

            if (x != y) {
                result[e++] = next_edge;
                union(parent, x, y);
            }
        }

        System.out.println("Edges in the MST:");
        for (i = 0; i < e; ++i)
            System.out.println(result[i].src + " - "
                    + result[i].dest + ": " + result[i].weight);
    }

    int V, E;
    Edge[] edges;

    public Kruskal(int V, int E) {
        this.V = V;
        this.E = E;
        edges = new Edge[E];
    }

    int find(int[] parent, int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }


}

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    // Compare two edges based on their weight
    @Override
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}
