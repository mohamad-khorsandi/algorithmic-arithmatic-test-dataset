package org.example;
import java.io.*;


class HigherOrderPrimeDetection {

    static void superPrimes(int n)
    {

        boolean isPrime[] = new boolean[n + 1];
        SieveOfEratosthenes(n, isPrime);

        int primes[] = new int[n + 1];
        int j = 0;

        for (int p = 2; p <= n; p++)
            if (isPrime[p])
                primes[j++] = p;

        for (int k = 0; k < j; k++)
            if (isPrime[k + 1])
                System.out.print(primes[k] + " ");
    }

    // Driven program
    public static void main(String args[])
    {
        int n = 241;
        System.out.println(
                "Super-Primes less than or equal to " + n + " are :");
        superPrimes(n);
    }

    // Generate all prime numbers less than n.
    static void SieveOfEratosthenes(int n, boolean isPrime[])
    {
        // Initialize all entries of boolean array as true.
        // A value in isPrime[i] will finally be false if i
        // is Not a prime, else true bool isPrime[n+1];
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= n; i++)
            isPrime[i] = true;

        for (int p = 2; p * p <= n; p++) {
            // If isPrime[p] is not changed, then it is a prime
            if (isPrime[p] == true) {
                // Update all multiples of p
                for (int i = p * 2; i <= n; i += p)
                    isPrime[i] = false;
            }
        }
    }

    // Pri
}

// This code is contributed by Aditya Kumar (adityakumar129)