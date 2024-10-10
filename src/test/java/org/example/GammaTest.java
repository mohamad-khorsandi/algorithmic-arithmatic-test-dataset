package org.example;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GammaFunctionTest {

    @Test
    public void testGammaHalf() {
        // Gamma(0.5) is approximately sqrt(π)
        double expected = Math.sqrt(Math.PI);
        double actual = Gamma.gamma(0.5);
        assertEquals(expected, actual, 1e-6, "Gamma(0.5) should be approximately sqrt(π)");
    }

    @Test
    public void testGammaOne() {
        // Gamma(1) is 0! = 1
        double expected = 1.0;
        double actual = Gamma.gamma(1.0);
        assertEquals(expected, actual, 1e-6, "Gamma(1) should be 1");
    }

    @Test
    public void testGammaFive() {
        // Gamma(5) is 4! = 24
        double expected = 24.0;
        double actual = Gamma.gamma(5.0);
        assertEquals(expected, actual, 1e-6, "Gamma(5) should be 24");
    }

    @Test
    public void testGammaNegativeHalf() {
        // Gamma(-0.5) is approximately -2 * sqrt(π)
        double expected = -2 * Math.sqrt(Math.PI);
        double actual = Gamma.gamma(-0.5);
        assertEquals(expected, actual, 1e-6, "Gamma(-0.5) should be approximately -2 * sqrt(π)");
    }

    @Test
    public void testGammaLargeValue() {
        // For large values, we can check if the function handles it without error
        double result = Gamma.gamma(100.0);
        assertTrue(result > 0, "Gamma(100) should be a large positive number");
    }
}
