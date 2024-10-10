package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BesselTest {

    @Test
    public void testBesselJ() {
        // Test case for Bessel function J_0(x)
        double resultJ0 = Bessel.besselJ(0, 5.0);
        assertEquals(-0.1775967713143383, resultJ0, 1e-10);

        // Test case for Bessel function J_1(x)
        double resultJ1 = Bessel.besselJ(1, 5.0);
        assertEquals(-0.32757913759146594, resultJ1, 1e-10);

        // Test case for Bessel function J_2(x)
        double resultJ2 = Bessel.besselJ(2, 5.0);
        assertEquals(0.0465651162777523, resultJ2, 1e-10);
    }
}
