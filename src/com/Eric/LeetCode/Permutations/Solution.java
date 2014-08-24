package com.Eric.LeetCode.Permutations;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution
{
    public List<List<Integer>> permute(int[] num)
    {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0)
            return result;

        Stack<Integer> path = new Stack<Integer>();
        ArrayList<Integer> input = new ArrayList<Integer>();
        for (int n : num)
            input.add(n);
        generatePermuation(input, result, path);


        return result;
    }

    private void generatePermuation(List<Integer> num, ArrayList<List<Integer>> result, Stack<Integer> path)
    {
        if (num.size() == 1)
        {
            path.push(num.get(0));
            ArrayList<Integer> onePermutation = new ArrayList<Integer>(path);
            result.add(onePermutation);
            path.pop();
            return;
        }

        int size = num.size();
        for (int i = 0; i < size; i++)
        {
            // Pick one
            int current = num.get(i);
            path.push(current);
            // Remove this one from numbers
            num.remove(i);
            // Go to next level
            generatePermuation(num, result, path);
            // Add this number back
            num.add(i, current);
            path.pop();
        }
    }
}
