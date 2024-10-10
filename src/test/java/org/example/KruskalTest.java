package org.example;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class KruskalTest {

    @Test
    public void testKruskalMST() {
        List<Kruskal.Edge> edges = new ArrayList<>();
        edges.add(new Kruskal.Edge(0, 1, 10));
        edges.add(new Kruskal.Edge(0, 2, 6));
        edges.add(new Kruskal.Edge(0, 3, 5));
        edges.add(new Kruskal.Edge(1, 3, 15));
        edges.add(new Kruskal.Edge(2, 3, 4));

        List<Kruskal.Edge> mst = Kruskal.kruskalMST(4, edges);

        assertEquals(3, mst.size());  // Number of edges in MST should be numVertices - 1
        assertTrue(mst.contains(new Kruskal.Edge(2, 3, 4)));
        assertTrue(mst.contains(new Kruskal.Edge(0, 3, 5)));
        assertTrue(mst.contains(new Kruskal.Edge(0, 1, 10)));
    }

    @Test
    public void testDisconnectedGraph() {
        List<Kruskal.Edge> edges = new ArrayList<>();
        edges.add(new Kruskal.Edge(0, 1, 10));
        edges.add(new Kruskal.Edge(2, 3, 5));

        List<Kruskal.Edge> mst = Kruskal.kruskalMST(4, edges);  // 4 vertices but not all connected

        assertEquals(2, mst.size());  // Only 2 edges can be included in the MST (one for each connected component)
    }

    @Test
    public void testSingleEdge() {
        List<Kruskal.Edge> edges = new ArrayList<>();
        edges.add(new Kruskal.Edge(0, 1, 1));

        List<Kruskal.Edge> mst = Kruskal.kruskalMST(2, edges);

        assertEquals(1, mst.size());  // MST contains only one edge
        assertTrue(mst.contains(new Kruskal.Edge(0, 1, 1)));
    }
}
