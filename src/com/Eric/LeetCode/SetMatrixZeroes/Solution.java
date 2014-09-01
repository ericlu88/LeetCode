package com.Eric.LeetCode.SetMatrixZeroes;

public class Solution
{
    public void setZeroes(int[][] matrix)
    {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;

        // Find out if the first row and first column has zeroes
        boolean hasFirstRowZero = false;
        for (int i = 0; i < matrix[0].length; i++)
        {
            if (matrix[0][i] == 0)
            {
                hasFirstRowZero = true;
                break;
            }
        }
        boolean hasFirstColumnZero = false;
        for (int i = 0; i < matrix.length; i++)
        {
            if (matrix[i][0] == 0)
            {
                hasFirstColumnZero = true;
                break;
            }
        }

        // Store If the entire row/column has zero from 1 to n-1 in the first row/column
        for (int i = 1; i < matrix.length; i++)
        {
            for (int j = 1; j < matrix[i].length; j++)
            {
                if (matrix[i][j] == 0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Convert entire row/column to zero from 1 to n-1 if in the first row/column
        for (int i = 1; i < matrix.length; i++)
        {
            if (matrix[i][0] == 0)
            {
                for (int j = 1; j < matrix[j].length; j++)
                    matrix[i][j] = 0;
            }
        }
        for (int j = 1; j < matrix[0].length; j++)
        {
            if (matrix[0][j] == 0)
            {
                for (int i = 1; i < matrix.length; i++)
                    matrix[i][j] = 0;
            }
        }

        // Convert first row/column to zero if needed
        if (hasFirstColumnZero)
        {
            for (int i = 0; i < matrix.length; i++)
            {
                matrix[i][0] = 0;
            }
        }
        if (hasFirstRowZero)
        {
            for (int i = 0; i < matrix[0].length; i++)
            {
                matrix[0][i] = 0;
            }
        }
    }
}
