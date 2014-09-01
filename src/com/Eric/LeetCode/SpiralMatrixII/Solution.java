package com.Eric.LeetCode.SpiralMatrixII;

public class Solution
{
    public int[][] generateMatrix(int n)
    {
        // Initialize result
        int[][] result = new int[n][];
        for (int i = 0; i < n; i++)
            result[i] = new int[n];

        if (n <= 0)
            return result;

        int numLevel = Math.max(n/2, (n+1)/2);
        int number = 0;
        int currentLevelLength = n;
        int i = 0, j = -1;

        for (int currentLevel = numLevel; currentLevel > 0; currentLevel--)
        {
            // Move from left top corner to left right corner
            for (int k = 0; k < currentLevelLength; k++)
            {
                j++;
                number++;
                result[i][j] = number;
            }

            // Move from right top corner to right down corner
            for (int k = 1; k < currentLevelLength; k++)
            {
                i++;
                number++;
                result[i][j] = number;
            }

            // Move from right down corner to left down corner
            for (int k = 1; k < currentLevelLength; k++)
            {
                j--;
                number++;
                result[i][j] = number;
            }

            // Move from left down corner to left top corner
            for (int k = 1; k < currentLevelLength - 1; k++)
            {
                i--;
                number++;
                result[i][j] = number;
            }

            currentLevelLength -= 2;
        }

        return result;
    }
}
