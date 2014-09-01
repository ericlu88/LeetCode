package com.Eric.LeetCode.Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution
{
    public List<List<Integer>> subsets(int[] S)
    {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (S == null || S.length == 0)
            return results;

        Arrays.sort(S);

        for (int i = 1; i <= S.length; i++)
        {
            Integer[] picked = new Integer[i];
            combination(S, 0, i, picked, results);
        }
        results.add(new ArrayList<Integer>());
        return results;
    }

    private void combination(int[] num, int startingIndex, int k, Integer[] picked, List<List<Integer>> result)
    {
        if (k == 1)
        {
            for (int i = startingIndex; i < num.length; i++)
            {
                picked[picked.length - k] = num[i];
                result.add(new ArrayList<Integer>(Arrays.asList(picked)));
            }
        }
        else
        {
            for (int i = startingIndex; i < num.length; i++)
            {
                picked[picked.length - k] = num[i];
                combination(num, i + 1, k - 1, picked, result);
            }
        }
    }
}
