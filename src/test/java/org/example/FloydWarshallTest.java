package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.example.FloydWarshall;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FloydWarshallTest {
    final static int INF = 99999;

    @Test
    public void testSimpleGraph() {
        FloydWarshall fw = new FloydWarshall();

        // A simple 4-node graph
        int graph[][] = {
                {0,   3,   INF, 5},
                {2,   0,   INF, 4},
                {INF, 1,   0,   INF},
                {INF, INF, 2,   0}
        };

        int expected[][] = {
                {0,   3,   7,   5},
                {2,   0,   6,   4},
                {3,   1,   0,   5},
                {5,   3,   2,   0}
        };

        int[][] result = fw.floydWarshall(graph);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testDisconnectedGraph() {
        FloydWarshall fw = new FloydWarshall();

        // A graph where some nodes are disconnected
        int graph[][] = {
                {0,   INF, 3,   INF},
                {2,   0,   INF, INF},
                {INF, 7,   0,   1},
                {6,   INF, INF, 0}
        };

        int expected[][] = {
                {0,   10,  3,   4},
                {2,   0,   5,   6},
                {7,   7,   0,   1},
                {6,   16,  9,   0}
        };

        int[][] result = fw.floydWarshall(graph);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSingleNodeGraph() {
        FloydWarshall fw = new FloydWarshall();

        // A graph with only one node
        int graph[][] = {
                {0}
        };

        int expected[][] = {
                {0}
        };

        int[][] result = fw.floydWarshall(graph);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testAllDisconnectedGraph() {
        FloydWarshall fw = new FloydWarshall();

        // A fully disconnected graph (no edges except self-loops)
        int graph[][] = {
                {0, INF, INF},
                {INF, 0, INF},
                {INF, INF, 0}
        };

        int expected[][] = {
                {0, INF, INF},
                {INF, 0, INF},
                {INF, INF, 0}
        };

        int[][] result = fw.floydWarshall(graph);
        assertArrayEquals(expected, result);
    }
}
