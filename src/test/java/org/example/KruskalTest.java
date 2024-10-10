package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class KruskalTest {

    Kruskal graph;

    @BeforeEach
    public void setUp() {
        int vertices = 4;  // Number of vertices
        int edges = 5;     // Number of edges
        graph = new Kruskal(vertices, edges);

        // Add edges
        graph.edgeArray[0].source = 0;
        graph.edgeArray[0].destination = 1;
        graph.edgeArray[0].weight = 10;

        graph.edgeArray[1].source = 0;
        graph.edgeArray[1].destination = 2;
        graph.edgeArray[1].weight = 6;

        graph.edgeArray[2].source = 0;
        graph.edgeArray[2].destination = 3;
        graph.edgeArray[2].weight = 5;

        graph.edgeArray[3].source = 1;
        graph.edgeArray[3].destination = 3;
        graph.edgeArray[3].weight = 15;

        graph.edgeArray[4].source = 2;
        graph.edgeArray[4].destination = 3;
        graph.edgeArray[4].weight = 4;
    }

    @Test
    public void testApplyKruskal() {
        // Capture the console output using a custom output stream
        java.io.ByteArrayOutputStream outputStream = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outputStream));

        // Run the Kruskal algorithm
        graph.applyKruskal();

        // Get the result from the captured output
        String result = outputStream.toString().trim();

        // Expected output: minimum spanning tree with correct edges
        String expectedOutput = "2 - 3: 4\n0 - 3: 5\n0 - 1: 10";

        // Normalize both actual and expected output by trimming and replacing extra whitespace
        String normalizedResult = result.replaceAll("\\s+", "");
        String normalizedExpectedOutput = expectedOutput.replaceAll("\\s+", "");

        // Test if the result matches the expected MST output
        assertEquals(normalizedExpectedOutput, normalizedResult);
    }
}
