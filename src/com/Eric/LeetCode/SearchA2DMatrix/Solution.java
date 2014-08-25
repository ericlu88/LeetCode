package com.Eric.LeetCode.SearchA2DMatrix;

public class Solution
{
    public boolean searchMatrix(int[][] matrix, int target)
    {
        int targetRow = binarySearchRowIndex(matrix, target, 0 ,matrix.length - 1);
        if (targetRow < 0)
            return false;

        int[] targetRowArray = matrix[targetRow];
        return binarySearchRow(targetRowArray, target, 0, targetRowArray.length - 1);
    }

    private int binarySearchRowIndex(int[][] matrix, int target, int startingIndex, int endingIndex)
    {
        if (startingIndex == endingIndex)
            return startingIndex;

        int mid = (startingIndex + endingIndex)/2;

        // Target is less than the current mid row first element
        if (target < matrix[mid][0])
        {
            // If the current row is the starting index, then this number is not present
            if (mid == startingIndex)
                return -1;
            // Otherwise, binary search the other section
            return binarySearchRowIndex(matrix, target, startingIndex, mid - 1);
        }
        // Target is larger than the current mid row first element
        else
        {
            // If target is less than the current mid row last element, it is within this row
            if (target <= matrix[mid][matrix[mid].length - 1])
                return mid;
            // Target is larger than the current mid row last element
            else
            {
                // If the current row is the last ending index, it is not present
                if (mid == endingIndex)
                    return -1;
                // Otherwise, binary search the other section
                return binarySearchRowIndex(matrix, target, mid + 1, endingIndex);
            }
        }
    }

    private boolean binarySearchRow(int[] array, int target, int startingIndex, int endingIndex)
    {
        if (startingIndex == endingIndex)
            return array[startingIndex] == target;

        int mid = (startingIndex + endingIndex) / 2;
        if (target == array[mid])
            return true;
        else if (target < array[mid])
        {
            if (mid == startingIndex)
                return false;
            return binarySearchRow(array,target,startingIndex,mid-1);
        }
        else
        {
            if (mid == endingIndex)
                return false;
            return binarySearchRow(array,target,mid + 1,endingIndex);
        }
    }
}
