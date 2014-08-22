package com.Eric.LeetCode.GrayCode;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public List<Integer> grayCode(int n)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (n == 0)
        {
            result.add(0);
            return result;
        }

        int current = 0;
        int multiplier = 1;
        Direction d = Direction.left;
        result.add(current);
        for (int i = 1; i < Math.pow(2, n); i ++)
        {
            current = current ^ multiplier;
            result.add(current);
            multiplier = d == Direction.left ? multiplier << 1: multiplier >> 1;

            if (n > 1 &&i % (n - 1) == 0)
            {
                d = d == Direction.left ? Direction.right : Direction.left;
            }
        }
        return result;
    }

    enum Direction
    {
        left,
        right
    }
}