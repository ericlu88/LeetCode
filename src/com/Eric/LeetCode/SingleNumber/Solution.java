package com.Eric.LeetCode.SingleNumber;

public class Solution
{
    public static int singleNumber(int[] A)
    {
        if (A == null || A.length == 0)
            return 0;

        int temp = A[0];
        for (int i = 1; i < A.length; i++)
        {
            temp ^= A[i];
        }
        return temp;
    }
}
