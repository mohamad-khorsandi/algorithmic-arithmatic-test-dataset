package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.example.FloydWarshall;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FloydWarshallTest {

    final static int INF = 99999; // Define INF value to be used in tests
    FloydWarshall allPairShortestPath = new FloydWarshall();

    @Test
    public void testFloydWarshall() {
        // Define input graph (same as in the main method)
        int graph[][] = {
                { 0, 5, INF, 10 },
                { INF, 0, 3, INF },
                { INF, INF, 0, 1 },
                { INF, INF, INF, 0 }
        };

        // Define expected result after running Floyd-Warshall
        int expected[][] = {
                { 0, 5, 8, 9 },
                { INF, 0, 3, 4 },
                { INF, INF, 0, 1 },
                { INF, INF, INF, 0 }
        };

        // Call Floyd-Warshall algorithm on the input graph
        allPairShortestPath.floydWarshall(graph);

        // Assert that the resulting distances matrix matches the expected matrix
        assertArrayEquals(expected, graph);
    }
}
