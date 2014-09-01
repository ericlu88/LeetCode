package com.Eric.LeetCode.Combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution
{
    public List<List<Integer>> combine(int n, int k)
    {
        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if (n <=0 || k<=0 || n <k)
            return results;

        int[] nums = new int[n];
        for (int i =0; i < n; i++)
            nums[i] = i + 1;
        Integer[] picked = new Integer[k];


        combination(nums, 0, k, picked, results);

        return results;
    }

    private void combination(int[] nums, int startingIndex, int k, Integer[] picked, List<List<Integer>> results)
    {
        if (k == 1)
        {
            for (int i  = startingIndex; i < nums.length; i++)
            {
                picked[picked.length - k] = nums[i];
                results.add(new ArrayList<Integer>(Arrays.asList(picked)));
            }
            return;
        }

        for (int i  = startingIndex; i < nums.length; i++)
        {
            picked[picked.length - k] = nums[i];
            combination(nums, i+1, k-1, picked, results);
        }
    }
}
