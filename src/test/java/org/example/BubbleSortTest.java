package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    public void testBubbleSort() {
        // Test case 1: Standard unsorted array
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int[] expected = {11, 12, 22, 25, 34, 64, 90};
        BubbleSort.bubbleSort(arr, arr.length);
        assertArrayEquals(expected, arr);

        // Test case 2: Array with one element
        int[] arrSingle = {5};
        int[] expectedSingle = {5};
        BubbleSort.bubbleSort(arrSingle, arrSingle.length);
        assertArrayEquals(expectedSingle, arrSingle);

        // Test case 3: Already sorted array
        int[] arrSorted = {1, 2, 3, 4, 5};
        int[] expectedSorted = {1, 2, 3, 4, 5};
        BubbleSort.bubbleSort(arrSorted, arrSorted.length);
        assertArrayEquals(expectedSorted, arrSorted);

        // Test case 4: Array with duplicates
        int[] arrWithDuplicates = {4, 5, 2, 2, 1};
        int[] expectedWithDuplicates = {1, 2, 2, 4, 5};
        BubbleSort.bubbleSort(arrWithDuplicates, arrWithDuplicates.length);
        assertArrayEquals(expectedWithDuplicates, arrWithDuplicates);

        // Test case 5: Empty array
        int[] emptyArray = {};
        int[] expectedEmpty = {};
        BubbleSort.bubbleSort(emptyArray, emptyArray.length);
        assertArrayEquals(expectedEmpty, emptyArray);
    }
}
