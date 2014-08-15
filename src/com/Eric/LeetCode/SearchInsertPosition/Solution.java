package com.Eric.LeetCode.SearchInsertPosition;

public class Solution
{
    public int searchInsert(int[] A, int target)
    {
        if (A == null || A.length == 0)
            return 0;

        return search(A, target, 0, A.length - 1);
    }

    private int search(int[] A, int target, int startingIndex, int endingIndex)
    {
        if (startingIndex == endingIndex)
        {
            if (A[startingIndex] >= target)
                return startingIndex;
            else
                return startingIndex + 1;
        }

        int pivotIndex = (startingIndex + endingIndex) / 2;

        if (A[pivotIndex] == target)
            return pivotIndex;
        else if (A[pivotIndex] > target)
        {
            if (pivotIndex - 1 >= startingIndex)
                return search(A, target, startingIndex, pivotIndex - 1);
            else
                return pivotIndex;
        }
        else
        {
            if (endingIndex  >= pivotIndex + 1)
                return search(A, target, pivotIndex + 1, endingIndex);
            else
                return pivotIndex + 1;
        }
    }
}
