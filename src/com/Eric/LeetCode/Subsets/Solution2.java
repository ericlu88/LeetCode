package com.Eric.LeetCode.Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2
{
    public List<List<Integer>> subsets(int[] S)
    {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (S == null || S.length == 0)
            return results;

        Arrays.sort(S);
        for (int i = 0; i < Math.pow(2, S.length); i++)
        {
            String binary = Integer.toBinaryString(i);
            results.add(convert(S,binary));
        }
        return results;
    }

    private List<Integer> convert(int[] S, String binary)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        char[] chars = binary.toCharArray();
        for (int i = S.length - chars.length, j = 0; i < S.length; i++, j++)
        {
            if (chars[j] == '1')
                result.add(S[i]);
        }
        return result;
    }
}
