package org.example;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

class PrimeFactorsTest {

    @Test
    void testPrimeFactorsOfPositiveNumber() {
        // Test for a composite number
        int input = 28; // Prime factors: 2, 2, 7
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2, 2, 7));
        ArrayList<Integer> result = PrimeFactors.primeFactors(input);
        assertEquals(expected, result, "Prime factors of 28 should be [2, 2, 7]");
    }

    @Test
    void testPrimeFactorsOfPrimeNumber() {
        // Test for a prime number
        int input = 13; // Prime factors: 13
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(13));
        ArrayList<Integer> result = PrimeFactors.primeFactors(input);
        assertEquals(expected, result, "Prime factors of 13 should be [13]");
    }

    @Test
    void testPrimeFactorsOfOne() {
        // Test for 1 (special case, no prime factors)
        int input = 1;
        ArrayList<Integer> expected = new ArrayList<>();
        ArrayList<Integer> result = PrimeFactors.primeFactors(input);
        assertEquals(expected, result, "Prime factors of 1 should be []");
    }

    @Test
    void testPrimeFactorsOfZero() {
        // Test for 0 (might throw an exception or return an empty list)
        int input = 0;
        assertThrows(IllegalArgumentException.class, () -> PrimeFactors.primeFactors(input),
                "Prime factors of 0 should throw IllegalArgumentException");
    }

    @Test
    void testPrimeFactorsOfNegativeNumber() {
        // Test for a negative number
        int input = -15;
        assertThrows(IllegalArgumentException.class, () -> PrimeFactors.primeFactors(input),
                "Prime factors of a negative number should throw IllegalArgumentException");
    }
}


