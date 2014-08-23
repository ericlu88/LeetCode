package com.Eric.LeetCode.SortColors;

// Solution come from https://oj.leetcode.com/discuss/1827/anyone-with-one-pass-and-constant-space-solution
public class Solution
{
    public void sortColors(int[] A)
    {
        if (A == null)
            return;

        int i = -1, j = -1, k = -1;
        for (int a : A)
        {
            if (a == 0)
            {
                A[++k] = 2;
                A[++j] = 1;
                A[++i] = 0;
            }
            else if (a == 1)
            {
                A[++k] = 2;
                A[++j] = 1;
            }
            else
                A[++k] = 2;
        }
    }
}
