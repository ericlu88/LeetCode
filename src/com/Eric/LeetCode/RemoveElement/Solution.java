package com.Eric.LeetCode.RemoveElement;

public class Solution
{
    public int removeElement(int[] A, int elem)
    {
        if (A == null)
            return 0;

        int i = 0;
        for (i = 0; i < A.length; i ++)
        {
            if (A[i] == elem)
            {
                int j = i + 1;
                while (j < A.length && A[j] == elem)
                    j++;
                if (j == A.length)
                    break;

                else
                {
                    A[i] = A[j];
                    A[j] = elem;
                }
            }
        }
        return i;
    }
}
