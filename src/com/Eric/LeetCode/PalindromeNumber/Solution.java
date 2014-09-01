package com.Eric.LeetCode.PalindromeNumber;

public class Solution
{
    public boolean isPalindrome(int x)
    {
        if (x < 0)
            return false;

        int input = x;
        int reverse = 0;

        while (x != 0)
        {
            int temp = x % 10;
            reverse = reverse * 10 + temp;
            x = (x - temp) / 10;
        }

        return reverse == input;
    }
}
