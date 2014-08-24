package com.Eric.LeetCode.UniquePaths;
import java.math.BigInteger;

public class Solution
{
    public int uniquePaths(int m, int n)
    {
        int down = m - 1;
        int right = n - 1;

        return combination(down + right, down);
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
