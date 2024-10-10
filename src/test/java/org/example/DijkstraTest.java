package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Map;

public class DijkstraTest {

    @Test
    public void testShortestPath() {
        int[][] graph = {
                {0, 7, 9, 0, 0, 14},
                {7, 0, 10, 15, 0, 0},
                {9, 10, 0, 11, 0, 2},
                {0, 15, 11, 0, 6, 0},
                {0, 0, 0, 6, 0, 9},
                {14, 0, 2, 0, 9, 0}
        };
        Map<Integer, Integer> distances = Dijkstra.dijkstra(graph, 0);

        assertEquals(0, distances.get(0));  // Distance to source
        assertEquals(7, distances.get(1));  // Distance to vertex 1
        assertEquals(9, distances.get(2));  // Distance to vertex 2
        assertEquals(20, distances.get(3)); // Distance to vertex 3
        assertEquals(20, distances.get(4)); // Distance to vertex 4
        assertEquals(11, distances.get(5)); // Distance to vertex 5
    }

    @Test
    public void testDisconnectedGraph() {
        int[][] graph = {
                {0, 0, 0, 0},
                {0, 0, 5, 0},
                {0, 5, 0, 0},
                {0, 0, 0, 0}
        };
        Map<Integer, Integer> distances = Dijkstra.dijkstra(graph, 0);

        assertEquals(0, distances.get(0)); // Distance to source
        assertEquals(Integer.MAX_VALUE, distances.get(1)); // Distance to vertex 1 (disconnected)
        assertEquals(Integer.MAX_VALUE, distances.get(2)); // Distance to vertex 2 (disconnected)
        assertEquals(Integer.MAX_VALUE, distances.get(3)); // Distance to vertex 3 (disconnected)
    }

    @Test
    public void testSingleVertex() {
        int[][] graph = {{0}};
        Map<Integer, Integer> distances = Dijkstra.dijkstra(graph, 0);

        assertEquals(0, distances.get(0)); // Distance to the single vertex
    }
}
