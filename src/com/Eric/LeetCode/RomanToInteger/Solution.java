package com.Eric.LeetCode.RomanToInteger;

import java.util.HashMap;

public class Solution
{
    public int romanToInt(String s)
    {
        // Initialize numeral table
        ROMAN_NUMERAL_TABLE.put('I', 1);
        ROMAN_NUMERAL_TABLE.put('V', 5);
        ROMAN_NUMERAL_TABLE.put('X', 10);
        ROMAN_NUMERAL_TABLE.put('L', 50);
        ROMAN_NUMERAL_TABLE.put('C', 100);
        ROMAN_NUMERAL_TABLE.put('D', 500);
        ROMAN_NUMERAL_TABLE.put('M', 1000);

        if (s == null)
            return 0;

        int result = 0;
        int c_val_current = 0;
        int c_val_previous = 0;
        for (int i =0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            c_val_current = ROMAN_NUMERAL_TABLE.get(c);
            result += c_val_current;
            if (c_val_current > c_val_previous)
                result -= 2 * c_val_previous;
            c_val_previous = c_val_current;
        }
        return result;
    }

    private static final HashMap<Character, Integer> ROMAN_NUMERAL_TABLE = new HashMap<Character, Integer>();
}
