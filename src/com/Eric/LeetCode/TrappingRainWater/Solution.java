package com.Eric.LeetCode.TrappingRainWater;

public class Solution
{
    public int trap(int[] A)
    {
        if (A == null || A.length == 0)
            return 0;

        int all = 0;
        int block = 0;
        int minLevel = 0;
        int left = 0;
        int right = A.length - 1;

        while (left <= right)
        {
            if (A[left] < A[right])
            {
                if (A[left] > minLevel)
                {
                    all += (right - left + 1) * (A[left] - minLevel);
                    minLevel = A[left];
                }
                block += A[left];
                left++;
                continue;
            }
            else if(A[left] > A[right])
            {
                if (A[right] > minLevel)
                {
                    all += (right - left + 1) * (A[right] - minLevel);
                    minLevel = A[right];
                }
                block += A[right];
                right--;
                continue;
            }
            else
            {
                if (A[left] > minLevel)
                {
                    all += (right - left + 1) * (A[left] - minLevel);
                    minLevel = A[left];
                }
                if (left != right)
                {
                    block += A[left];
                    block += A[right];
                }
                else
                    block += A[right];
                left++;
                right--;
            }
        }

        return all - block;
    }
}
