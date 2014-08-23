package com.Eric.LeetCode.MergeSortedArray;

public class Solution
{
    public void merge(int A[], int m, int B[], int n)
    {
        if (B == null)
            return;

        ArrayIdentifier[] identifiers = new ArrayIdentifier[m + n];
        int i_A = 0;
        int i_B = 0;

        for (int i = 0; i < m + n; i++)
        {
            if (i_A == m)
            {
                identifiers[i] = new ArrayIdentifier(i_B, Array.B);
                i_B++;
            }
            else if (i_B == n)
            {
                identifiers[i] = new ArrayIdentifier(i_A, Array.A);
                i_A++;
            }
            else
            {
                if (A[i_A] < B[i_B])
                {
                    identifiers[i] = new ArrayIdentifier(i_A, Array.A);
                    i_A++;
                }
                else
                {
                    identifiers[i] = new ArrayIdentifier(i_B, Array.B);
                    i_B++;
                }
            }
        }

        for (int i = m + n - 1;i >=0; i--)
        {
            A[i] = identifiers[i].arr == Array.A ? A[identifiers[i].index] : B[identifiers[i].index];
        }
    }

    class ArrayIdentifier
    {
        Array arr;
        int index;
        ArrayIdentifier(int i, Array array)
        {
            index = i;
            arr = array;
        }
    }

    enum Array
    {
        A,
        B
    }
}
