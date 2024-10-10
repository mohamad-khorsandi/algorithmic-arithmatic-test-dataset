package org.example;

import java.util.*;

public class Dijkstra {
    // Function to find the shortest path from a source vertex to all other vertices in a weighted graph
    public static Map<Integer, Integer> dijkstra(int[][] graph, int source) {
        int numVertices = graph.length;
        Map<Integer, Integer> distances = new HashMap<>();
        boolean[] visited = new boolean[numVertices];

        // Initialize distances to infinity
        for (int i = 0; i < numVertices; i++) {
            distances.put(i, Integer.MAX_VALUE);
        }
        distances.put(source, 0);

        // Priority queue to select the vertex with the minimum distance
        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v.distance));
        pq.add(new Vertex(source, 0));

        while (!pq.isEmpty()) {
            Vertex current = pq.poll();
            int currentVertex = current.id;

            // Skip the vertex if it has already been visited
            if (visited[currentVertex]) {
                continue;
            }
            visited[currentVertex] = true;

            // Update distances to neighboring vertices
            for (int neighbor = 0; neighbor < numVertices; neighbor++) {
                if (graph[currentVertex][neighbor] != 0 && !visited[neighbor]) {  // Check for edges
                    int newDist = distances.get(currentVertex) + graph[currentVertex][neighbor];
                    if (newDist < distances.get(neighbor)) {
                        distances.put(neighbor, newDist);
                        pq.add(new Vertex(neighbor, newDist));
                    }
                }
            }
        }

        return distances;
    }

    // Inner class to represent a vertex with its distance
    private static class Vertex {
        int id;
        int distance;

        Vertex(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }
    }
}
