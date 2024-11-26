package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LucasPrimality {
    static ArrayList<Integer> factors
            = new ArrayList<Integer>();

    static ArrayList<Integer> primeFactors(int n)
    {
        // if 2 is a factor
        if (n % 2 == 0)
            factors.add(2);
        while (n % 2 == 0)
            n = n / 2;

        // if prime > 2 is factor
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

    static int power(int n, int r, int q)
    {
        int total = n;
        for (int i = 1; i < r; i++)
            total = (total * n) % q;
        return total;
    }

    static String isPrime(int n)
    {
        // Base cases
        if (n == 1)
            return "neither prime nor composite";
        if (n == 2)
            return "prime";
        if (n % 2 == 0)
            return "composite1";

        // Generating and storing factors
        // of n-1
        primeFactors(n - 1);

        // Array for random generator. This array
        // is to ensure one number is generated
        // only once
        int[] random = new int[n - 2];
        for (int i = 0; i < n - 2; i++)
            random[i] = i + 2;

        // shuffle random array to produce randomness
        Collections.shuffle(Arrays.asList(random));

        // Now one by one perform Lucas Primality
        // Test on random numbers generated.
        for (int i = 0; i < n - 2; i++) {
            int a = random[i];
            if (power(a, n - 1, n) != 1)
                return "composite";

            // this is to check if every factor
            // of n-1 satisfy the condition
            boolean flag = true;
            for (i = 0; i < factors.size(); i++) {
                // if a^((n-1)/q) equal 1
                if (power(a, (n - 1) / factors.get(i), n) == 1) {
                    flag = false;
                    break;
                }
            }

            // if all condition satisfy
            if (flag)
                return "prime";
        }
        return "probably composite";
    }
}
