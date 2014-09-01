package com.Eric.LeetCode.RemoveDuplicatesFromSortedArrayII;

public class Solution
{
    public int removeDuplicates(int[] A)
    {
        if (A == null || A.length == 0)
            return 0;

        int current = 0;
        while(current < A.length)
        {
            if (current == A.length - 1)
                return current + 1;

            if (A[current] == A[current + 1])
                current++;

            // Look for it's next biggest number
            int next = current + 1;
            while (next < A.length && A[next] <= A[current])
                next++;

            if (next == A.length)
                return current + 1;

            if (next == current + 1)
            {
                current++;
                continue;
            }

            // Swap A[next] with A[current+1]
            int temp = A[current + 1];
            A[current + 1] = A[next];
            A[next] = temp;
            current++;

            // Swap A[next + 1] with A[current + 1] if needed
            if (next + 1 < A.length && A[next + 1] == A[current])
            {
                temp = A[current + 1];
                A[current + 1] = A[next + 1];
                A[next + 1] = temp;
                current++;
            }
        }
        return A.length;
    }
}
