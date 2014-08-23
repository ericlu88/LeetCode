package com.Eric.LeetCode.PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if (numRows == 0)
            return triangle;

        ArrayList<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(1);
        triangle.add(firstRow);

        ArrayList<Integer> lastRow = firstRow;
        for (int i = 2; i <= numRows; i++)
        {
            ArrayList<Integer> currentRow = new ArrayList<Integer>();
            for (int j = 0; j < i; j++)
            {
                if (j == 0 || j == i - 1)
                    currentRow.add(1);
                else
                    currentRow.add(lastRow.get(j - 1) + lastRow.get(j));
            }
            lastRow = currentRow;
            triangle.add(currentRow);
        }
        return triangle;
    }
}
