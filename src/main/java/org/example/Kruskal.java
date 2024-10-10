package org.example;

import java.util.*;

public class Kruskal {

    // Class to represent an edge
    public static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        // Constructor
        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        // Method to compare two edges by their weight
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    // Class to represent a subset for union-find
    static class Subset {
        int parent, rank;
    }

    // Function to find set of an element (uses path compression)
    private static int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    // Function to unite two sets (uses union by rank)
    private static void union(Subset[] subsets, int x, int y) {
        int rootX = find(subsets, x);
        int rootY = find(subsets, y);

        if (subsets[rootX].rank < subsets[rootY].rank) {
            subsets[rootX].parent = rootY;
        } else if (subsets[rootX].rank > subsets[rootY].rank) {
            subsets[rootY].parent = rootX;
        } else {
            subsets[rootY].parent = rootX;
            subsets[rootX].rank++;
        }
    }

    // Kruskal's algorithm to find MST
    public static List<Edge> kruskalMST(int numVertices, List<Edge> edges) {
        List<Edge> result = new ArrayList<>();  // This will store the final MST
        Collections.sort(edges);  // Sort edges in increasing order of weight

        Subset[] subsets = new Subset[numVertices];
        for (int i = 0; i < numVertices; i++) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        int e = 0;  // Number of edges in MST
        int i = 0;  // Index used to pick edges one by one
        while (e < numVertices - 1) {
            Edge nextEdge = edges.get(i++);
            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);

            // If including this edge does not form a cycle
            if (x != y) {
                result.add(nextEdge);
                union(subsets, x, y);
                e++;
            }
        }
        return result;  // Return the MST
    }
}
