package com.Eric.LeetCode.MinimumPathSum;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// First approach I came up with. Bad
public class Solution
{
    public int minPathSum(int[][] grid)
    {
        if (grid == null || grid.length == 0)
            return 0;

        int down = grid.length - 1;
        int right = grid[0].length - 1;

        ArrayList<int[]> allPaths = new ArrayList<int[]>();
        Stack<Integer> p = new Stack<Integer>();
        ArrayList<Integer> positions = new ArrayList<Integer>();
        for (int i = 0; i < down + right; i++)
            positions.add(i);

        getCombination(positions, down + right, down, allPaths, p);

        int minSum = Integer.MAX_VALUE;
        for (int[] path : allPaths)
        {
            int currentSum = convertCombToSum(grid, path);
            if (currentSum < minSum)
                minSum = currentSum;
        }
        return minSum;
    }

    private void getCombination(List<Integer> input, int totalLength, int length, ArrayList<int[]> output, Stack<Integer> path)
    {
        for (int i = 0; i < input.size(); i++)
        {
            int currentNum = input.get(i);
            path.push(currentNum);
            if (length == 1)
            {
                int[] currentCombination = new int[totalLength];
                for (int j : path)
                    currentCombination[j] = 1; //0 is right, 1 is down
                output.add(currentCombination);
            }
            else
            {
                getCombination(input.subList(i + 1, input.size()), totalLength, length-1, output, path);
            }
            path.pop();
        }
    }

    private int convertCombToSum(int[][] grid, int[] path)
    {
        int x = 0, y = 0, sum = 0;
        for (int i : path)
        {
            sum += grid[x][y];
            if (i == 0)
                y++;
            else
                x++;
        }
        sum += grid[x][y];
        return sum;
    }
}
