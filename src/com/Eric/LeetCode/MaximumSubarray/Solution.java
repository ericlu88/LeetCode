package com.Eric.LeetCode.MaximumSubarray;

public class Solution
{
    public int maxSubArray(int[] A)
    {
        if (A == null || A.length == 0)
            return 0;

        int maxSum = A[0];
        int runningSum = 0;
        for (int a : A) {
            runningSum += a;
            if (runningSum <= 0) {
                if (runningSum > maxSum)
                    maxSum = runningSum;
                runningSum = 0;
                continue;
            }
            if (runningSum > maxSum)
                maxSum = runningSum;
        }
        return maxSum;
    }
}
