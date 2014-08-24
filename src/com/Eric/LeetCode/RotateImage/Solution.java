package com.Eric.LeetCode.RotateImage;

// Not an in-place solution
public class Solution
{
    public void rotate(int[][] matrix)
    {
        if (matrix == null || matrix.length == 0)
            return;

        int n = matrix.length;
        int[][] rotated = new int[n][];
        for (int i = 0; i < n; i++)
        {
            rotated[i] = new int[n];
            for (int j = n - 1; j >= 0; j--)
                rotated[i][n - j - 1] = matrix[j][i];
        }

        for (int i = 0 ; i < n; i++)
            System.arraycopy(rotated[i], 0, matrix[i], 0, n);
    }
}
