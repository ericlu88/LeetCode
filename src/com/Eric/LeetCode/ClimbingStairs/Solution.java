package com.Eric.LeetCode.ClimbingStairs;

import java.math.BigInteger;

public class Solution
{
    public int climbStairs(int n)
    {
        int result = 0;
        if (n <= 0)
            return result;

        // For n steps, we could separate it to [n/2, n] steps
        for (int m = (int)Math.ceil(n / 2.0); m <= n; m++)
        {
            // There will be X 2 steps, Y 1 steps
            int x = n - m;
            //int y = 2 * m - n;

            // The number of combination for m steps
            int comb = combination(m, x);
            result += comb;
        }
        return result;
    }

    private int combination(int n, int k)
    {
        BigInteger n_big = factorial(convertToBigInteger(n));
        BigInteger k_big = factorial(convertToBigInteger(k));
        BigInteger n_k_big = factorial(convertToBigInteger(n-k));

        return n_big.divide(k_big).divide(n_k_big).intValue();
    }

    private BigInteger factorial(BigInteger input) {
        if (input.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException("zero or negatives are not allowed");
        }

        BigInteger result = BigInteger.ONE;
        for (BigInteger i = BigInteger.ONE; i.compareTo(input) <= 0; i = i.add(BigInteger.ONE)) {
            result = result.multiply(i);
        }
        return result;
    }

    private BigInteger convertToBigInteger(int n)
    {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++)
            result = result.add(BigInteger.ONE);
        return result;
    }
}
