package org.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Map;

public class LevenshteinDistanceTest {

    @Test
    public void testSameStrings() {
        assertEquals(0, LevenshteinDistance.calculate("kitten", "kitten"));
    }

    @Test
    public void testOneInsertion() {
        assertEquals(1, LevenshteinDistance.calculate("kitten", "kittens"));
    }

    @Test
    public void testOneDeletion() {
        assertEquals(1, LevenshteinDistance.calculate("kittens", "kitten"));
    }

    @Test
    public void testOneSubstitution() {
        assertEquals(1, LevenshteinDistance.calculate("kitten", "sitten"));
    }

    @Test
    public void testMixedOperations() {
        assertEquals(3, LevenshteinDistance.calculate("kitten", "sitting"));
    }

    @Test
    public void testEmptyString() {
        assertEquals(6, LevenshteinDistance.calculate("", "kitten"));
        assertEquals(6, LevenshteinDistance.calculate("kitten", ""));
    }
}
