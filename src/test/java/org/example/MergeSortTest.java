package org.example;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class MergeSortTest {

    @Test
    public void testEmptyArray() {
        int[] array = {};
        MergeSort.sort(array);
        assertArrayEquals(new int[]{}, array);
    }

    @Test
    public void testSingleElement() {
        int[] array = {1};
        MergeSort.sort(array);
        assertArrayEquals(new int[]{1}, array);
    }

    @Test
    public void testAlreadySortedArray() {
        int[] array = {1, 2, 3, 4, 5};
        MergeSort.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    public void testReverseSortedArray() {
        int[] array = {5, 4, 3, 2, 1};
        MergeSort.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    public void testUnsortedArray() {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        MergeSort.sort(array);
        assertArrayEquals(new int[]{3, 9, 10, 27, 38, 43, 82}, array);
    }

    @Test
    public void testArrayWithDuplicates() {
        int[] array = {4, 1, 3, 2, 4, 1};
        MergeSort.sort(array);
        assertArrayEquals(new int[]{1, 1, 2, 3, 4, 4}, array);
    }
}
