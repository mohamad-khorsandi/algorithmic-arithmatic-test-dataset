package org.example;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {

    @Test
    public void testTargetExists() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        assertEquals(3, BinarySearch.binarySearch(array, 4));
    }

    @Test
    public void testTargetDoesNotExist() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        assertEquals(-1, BinarySearch.binarySearch(array, 8));
    }

    @Test
    public void testTargetAtStart() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        assertEquals(0, BinarySearch.binarySearch(array, 1));
    }

    @Test
    public void testTargetAtEnd() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        assertEquals(6, BinarySearch.binarySearch(array, 7));
    }

    @Test
    public void testEmptyArray() {
        int[] array = {};
        assertEquals(-1, BinarySearch.binarySearch(array, 1));
    }

    @Test
    public void testSingleElementArrayFound() {
        int[] array = {5};
        assertEquals(0, BinarySearch.binarySearch(array, 5));
    }

    @Test
    public void testSingleElementArrayNotFound() {
        int[] array = {5};
        assertEquals(-1, BinarySearch.binarySearch(array, 1));
    }
}
