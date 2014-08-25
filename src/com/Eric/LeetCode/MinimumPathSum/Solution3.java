package com.Eric.LeetCode.MinimumPathSum;

// Copied from https://oj.leetcode.com/discuss/816/minimum-path-sum-how-can-i-reduce-the-memory
public class Solution3
{
    public int minPathSum(int[][] grid)
    {
        if (grid == null || grid.length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        int[] sum = new int[n + 1];
        for (int i = 0; i < n + 1; i++)
            sum[i] = Integer.MAX_VALUE;

        sum[1] = 0;
        for (int row = 0; row < m; row++)
        {
            for (int column = 0; column < n; column++)
            {
                sum[column + 1] = Math.min(sum[column], sum[column + 1]) + grid[row][column];
            }
        }
        return sum[n];
    }
}
