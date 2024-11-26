package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSelectTest {

    @Test
    public void testKthSmallestBasic() {
        int[] arr = {12, 3, 5, 7, 4, 19, 26};
        int k = 3;
        assertEquals(5, QuickSelect.kthSmallest(arr, 0, arr.length - 1, k));
    }

    @Test
    public void testKthSmallestEdgeCase1() {
        int[] arr = {1};
        int k = 1;
        assertEquals(1, QuickSelect.kthSmallest(arr, 0, arr.length - 1, k));
    }

    @Test
    public void testKthSmallestEdgeCase2() {
        int[] arr = {5, 4};
        int k = 2;
        assertEquals(5, QuickSelect.kthSmallest(arr, 0, arr.length - 1, k));
    }

    @Test
    public void testKthSmallestNegativeNumbers() {
        int[] arr = {-12, -3, -5, -7, -4, -19, -26};
        int k = 4;
        assertEquals(-7, QuickSelect.kthSmallest(arr, 0, arr.length - 1, k));
    }

    @Test
    public void testKthSmallestFirstElement() {
        int[] arr = {12, 3, 5, 7, 4, 19, 26};
        int k = 1;
        assertEquals(3, QuickSelect.kthSmallest(arr, 0, arr.length - 1, k));
    }

    @Test
    public void testKthSmallestLastElement() {
        int[] arr = {12, 3, 5, 7, 4, 19, 26};
        int k = 7;
        assertEquals(26, QuickSelect.kthSmallest(arr, 0, arr.length - 1, k));
    }

    @Test
    public void testKthSmallestOutOfRange() {
        int[] arr = {12, 3, 5, 7, 4, 19, 26};
        int k = 8;
        assertEquals(Integer.MAX_VALUE, QuickSelect.kthSmallest(arr, 0, arr.length - 1, k));
    }

    @Test
    public void testKthSmallestMultipleDuplicates() {
        int[] arr = {7, 7, 7, 7, 7, 7, 7};
        int k = 4;
        assertEquals(7, QuickSelect.kthSmallest(arr, 0, arr.length - 1, k));
    }

    @Test
    public void testKthSmallestSortedArray() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 5;
        assertEquals(5, QuickSelect.kthSmallest(arr, 0, arr.length - 1, k));
    }

    @Test
    public void testKthSmallestReversedArray() {
        int[] arr = {7, 6, 5, 4, 3, 2, 1};
        int k = 2;
        assertEquals(2, QuickSelect.kthSmallest(arr, 0, arr.length - 1, k));
    }
}