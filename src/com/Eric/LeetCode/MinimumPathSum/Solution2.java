package com.Eric.LeetCode.MinimumPathSum;

// Second approach I came up with. STILL EXCEED TIME LIMIT!!
public class Solution2
{
    int minSum;

    public int minPathSum(int[][] grid)
    {
        if (grid == null || grid.length == 0)
            return 0;

        minSum = Integer.MAX_VALUE;
        move(grid, 0, 0, 0);

        return minSum;
    }

    private void move(int[][] grid, int x, int y, int currentSum)
    {
        currentSum += grid[x][y];

        if (currentSum >= minSum)
            return;

        if (x == grid.length - 1 && y == grid[0].length - 1)
        {
            if (currentSum < minSum)
                minSum = currentSum;
        }
        else
        {
            if (x == grid.length - 1)
                move(grid, x, y + 1, currentSum);
            else if (y == grid[0].length - 1)
                move(grid, x + 1, y, currentSum);
            else
            {
                move(grid, x, y + 1, currentSum);
                move(grid, x + 1, y, currentSum);
            }
        }
    }
}
