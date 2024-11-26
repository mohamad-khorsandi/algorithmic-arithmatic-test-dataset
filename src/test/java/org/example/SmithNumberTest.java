package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmithNumberTest {
    @BeforeAll
    public static void prepare() {
        SmithNumber.sieveSundaram();
    }
    @Test
    public void testIsSmithNumber_22() {
        assertTrue(SmithNumber.isSmith(22), "22 should be a Smith number");
    }

    @Test
    public void testIsSmithNumber_27() {
        assertTrue(SmithNumber.isSmith(27), "27 should be a Smith number");
    }

    @Test
    public void testIsSmithNumber_58() {
        assertTrue(SmithNumber.isSmith(58), "58 should be a Smith number");
    }

    @Test
    public void testIsSmithNumber_85() {
        assertTrue(SmithNumber.isSmith(85), "85 should be a Smith number");
    }

    @Test
    public void testIsSmithNumber_121() {
        assertTrue(SmithNumber.isSmith(121), "121 should be a Smith number");
    }

    @Test
    public void testIsSmithNumber_166() {
        assertTrue(SmithNumber.isSmith(166), "166 should be a Smith number");
    }

    @Test
    public void testIsSmithNumber_391() {
        assertTrue(SmithNumber.isSmith(391), "391 should be a Smith number");
    }

    @Test
    public void testIsSmithNumber_438() {
        assertTrue(SmithNumber.isSmith(438), "438 should be a Smith number");
    }

    @Test
    public void testIsSmithNumber_0() {
        assertFalse(SmithNumber.isSmith(0), "0 should not be a Smith number");
    }

    @Test
    public void testIsSmithNumber_Prime() {
        assertFalse(SmithNumber.isSmith(7), "7 should not be a Smith number (it's prime)");
    }
}