package com.Eric.LeetCode.ReverseInteger;

public class Solution
{
    public int reverse(int x)
    {
        boolean isNegative = x < 0;
        if (isNegative) x = -x;

        int reverse = 0;
        while (x != 0)
        {
            int mod = x % 10;
            reverse = reverse * 10 + mod;
            x = (x - mod) / 10;
        }
        return isNegative ? -reverse : reverse;
    }
}
