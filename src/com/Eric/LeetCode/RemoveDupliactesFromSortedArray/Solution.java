package com.Eric.LeetCode.RemoveDupliactesFromSortedArray;

public class Solution
{
    public int removeDuplicates(int[] A)
    {
        if (A == null || A.length == 0)
            return 0;
        if (A.length == 1)
            return 1;

        for (int current = 0; current < A.length; current ++)
        {
            int next = current + 1;
            while (next < A.length && A[next] <= A[current])
                next ++;

            if (next == A.length)
                return current + 1;

            if (next == current + 1)
                continue;

            int temp = A[current + 1];
            A[current + 1] = A[next];
            A[next] = temp;
        }
        return A.length;
    }
}
