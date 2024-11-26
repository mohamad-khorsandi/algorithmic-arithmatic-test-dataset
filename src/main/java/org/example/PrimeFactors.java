package org.example;

import java.util.ArrayList;

public class PrimeFactors {

    static ArrayList<Integer> primeFactors(int n)
    {
        ArrayList<Integer> factors
                = new ArrayList<>();

        if (n % 2 == 0)
            factors.add(2);
        while (n % 2 == 0)
            n = n / 2;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                factors.add(i);
            while (n % i == 0)
                n = n / i;
        }
        if (n > 2)
            factors.add(n);
        return factors;
    }
}
