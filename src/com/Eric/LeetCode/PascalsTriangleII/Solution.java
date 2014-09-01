package com.Eric.LeetCode.PascalsTriangleII;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public List<Integer> getRow(int rowIndex)
    {
        List<Integer> lastRow = new ArrayList<Integer>();
        lastRow.add(1);
        if (rowIndex == 0)
            return lastRow;

        List<Integer> currentRow = new ArrayList<Integer>();
        for (int i  = 1; i <= rowIndex; i++)
        {
            currentRow = new ArrayList<Integer>();
            for (int j = 0; j < i + 1; j++)
            {
                if (j == 0 || j == i)
                    currentRow.add(1);
                else
                {
                    currentRow.add(lastRow.get(j-1) + lastRow.get(j));
                }
            }
            lastRow = currentRow;
        }
        return currentRow;
    }
}
