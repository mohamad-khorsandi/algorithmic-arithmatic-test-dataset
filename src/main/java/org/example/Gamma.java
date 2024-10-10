package org.example;

public class Gamma {

    // Lanczos coefficients
    private static final double[] COEFFICIENTS = {
            676.5203681218851, -1259.1392167224028, 771.32342877765313,
            -176.61502916214059, 12.507343278686905, -0.13857109526572012,
            9.9843695780195716e-6, 1.5056327351493116e-7
    };

    // Lanczos approximation for the Gamma function
    public static double gamma(double z) {
        if (z < 0.5) {
            // Use reflection formula for values < 0.5: Gamma(z) = π / (sin(πz) * Gamma(1 - z))
            return Math.PI / (Math.sin(Math.PI * z) * gamma(1 - z));
        }

        // Shift to z - 1
        z -= 1;

        double x = 0.99999999999980993;
        for (int i = 0; i < COEFFICIENTS.length; i++) {
            x += COEFFICIENTS[i] / (z + i + 1);
        }

        double t = z + COEFFICIENTS.length - 0.5;

        // Final Gamma calculation based on the approximation
        return Math.sqrt(2 * Math.PI) * Math.pow(t, z + 0.5) * Math.exp(-t) * x;
    }

    public static void main(String[] args) {
        // Example usage of the Gamma function
        double value = 5.5;
        double gammaResult = gamma(value);
        System.out.println("Gamma(" + value + ") = " + gammaResult);

        value = 0.5;
        gammaResult = gamma(value);
        System.out.println("Gamma(" + value + ") = " + gammaResult); // Should be approximately sqrt(π)
    }
}