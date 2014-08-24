package com.Eric.LeetCode.PlusOne;

public class Solution
{
    public int[] plusOne(int[] digits)
    {
        if (digits == null || digits.length == 0)
            return null;

        digits[digits.length - 1]++;

        int i = digits.length - 1;
        while(i >=0 && digits[i] > 9)
        {
            digits[i] -= 10;
            if (i != 0)
                digits[i-1] ++;
            else
            {
                int[] newdigits = new int[digits.length + 1];
                System.arraycopy(digits, 0, newdigits, 1, digits.length);
                newdigits[0]++;
                digits = newdigits;
            }
            i--;
        }
        return digits;
    }
}
