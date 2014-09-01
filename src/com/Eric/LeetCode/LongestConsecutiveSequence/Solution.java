package com.Eric.LeetCode.LongestConsecutiveSequence;

import java.util.HashMap;

public class Solution
{
    public int longestConsecutive(int[] num)
    {
        if (num == null || num.length == 0)
            return 0;

        HashMap<Integer, Integer> upperBound = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> lowerBound = new HashMap<Integer, Integer>();

        int longest = 0;
        for (int i : num)
        {
            // Duplicate number, ignore
            if (upperBound.containsKey(i))
                continue;

            int upper = i, lower = i;
            if (upperBound.containsKey(i + 1))
                upper = upperBound.get(i + 1);
            if (lowerBound.containsKey(i - 1))
                lower = lowerBound.get(i - 1);

            upperBound.put(i, upper);
            lowerBound.put(i,lower);

            upperBound.put(lower, upper);
            lowerBound.put(upper, lower);

            longest = Math.max(longest, upper - lower + 1);
        }
        return longest;
    }
}
