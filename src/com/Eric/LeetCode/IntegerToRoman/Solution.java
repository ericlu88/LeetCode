package com.Eric.LeetCode.IntegerToRoman;

import java.util.ArrayList;

public class Solution
{
    public String intToRoman(int num)
    {
        ArrayList<RomanNumberal> romans = new ArrayList<RomanNumberal>();
        // Initialize numeral
        romans.add(new RomanNumberal(1000, "M"));
        romans.add(new RomanNumberal(500, "D"));
        romans.add(new RomanNumberal(100, "C"));
        romans.add(new RomanNumberal(50, "L"));
        romans.add(new RomanNumberal(10, "X"));
        romans.add(new RomanNumberal(5, "V"));
        romans.add(new RomanNumberal(1, "I"));

        int remain = num;
        String result = "";
        for (int i = 0; i < romans.size(); i += 2)
        {
            RomanNumberal roman = romans.get(i);
            if (roman.val > remain)
                continue;

            int count = remain / roman.val;
            result = attach(result, count, romans, i);
            remain -= count * roman.val;
        }

        return result;
    }

    private String attach(String result, int count, ArrayList<RomanNumberal> romans, int i)
    {
        RomanNumberal roman = romans.get(i);
        if (count < 4)
        {
            for (int j = 0; j < count; j++)
                result += roman.c;
        }
        else if (count == 4)
        {
            RomanNumberal lastRoman = romans.get(i - 1);
            result += (roman.c + lastRoman.c);
        }
        else if (count == 9)
        {
            RomanNumberal lastTwoRoman = romans.get(i - 2);
            result += (roman.c + lastTwoRoman.c);
        }
        else
        {
            RomanNumberal lastRoman = romans.get(i - 1);
            result += lastRoman.c;
            for (int j = 0; j < count - 5; j++)
                result += roman.c;
        }
        return result;
    }

    class RomanNumberal
    {
        String c;
        int val;

        RomanNumberal(int Val, String C)
        {
            c = C;
            val = Val;
        }
    }
}
