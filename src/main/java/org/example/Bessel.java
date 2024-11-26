package org.example;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Bessel {

    public static double besselJ(int n, double x) {
        double sum = 0.0;
        int maxIterations = 50;
        for (int m = 0; m < maxIterations; m++) {
            double term = Math.pow(-1, m) / (factorial(m) * factorial(m + n));
            term *= Math.pow(x / 2.0, 2 * m + n);
            sum += term;

            if (Math.abs(term) < 1e-15) {
                break;
            }
        }
        return sum;
    }

    private static double factorial(int num) {
        if (num == 0) {
            return 1.0;
        }
        double result = 1.0;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}
