package org.example;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KruskalTest {

    @Test
    public void testKruskalMST() {
        // Initialize graph with 4 vertices and 5 edges
        int V = 4; // Number of vertices
        int E = 5; // Number of edges

        Kruskal kruskal = new Kruskal(V, E);

        // Add edges
        kruskal.edges[0] = new Edge(0, 1, 10);
        kruskal.edges[1] = new Edge(0, 2, 6);
        kruskal.edges[2] = new Edge(0, 3, 5);
        kruskal.edges[3] = new Edge(1, 3, 15);
        kruskal.edges[4] = new Edge(2, 3, 4);

        // Expected output: edges forming the MST
        // Edge 2-3 with weight 4
        // Edge 0-3 with weight 5
        // Edge 0-1 with weight 10

        // Capturing console output
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        // Run Kruskal's algorithm to find MST
        kruskal.kruskalMST();

        // Check if the output matches the expected MST
        String expectedOutput = "Edges in the MST:\r\n"
                + "2 - 3: 4\r\n"
                + "0 - 3: 5\r\n"
                + "0 - 1: 10\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
