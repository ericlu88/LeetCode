package com.Eric.LeetCode.GenerateParentheses;

import java.util.*;

public class Solution
{
    public List<String> generateParenthesis(int n)
    {
        ArrayList<String> result = new ArrayList<String>();
        if (n <= 0)
            return result;

        List<Integer> positions = new ArrayList<Integer>();
        for (int i = 0; i < 2 * n; i++)
        {
            positions.add(i);
        }

        for (ArrayList<Integer> position: generateAllPossibleParenthesisPosition(positions, n))
        {
            Collections.sort(position);
            String parenthesis = convertToString(position, 2 * n);
            if (checkValideParenthethis(parenthesis))
                result.add(parenthesis);
        }

        return result;
    }

    // Solution get from http://stackoverflow.com/questions/127704/algorithm-to-return-all-combinations-of-k-elements-from-n
    private ArrayList<ArrayList<Integer>> generateAllPossibleParenthesisPosition(List<Integer> positions, int length)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < positions.size(); i++)
        {
            if (length == 1)
            {
                ArrayList<Integer> pos = new ArrayList<Integer>();
                pos.add(positions.get(i));
                result.add(pos);
            }

            else
            {
                for (ArrayList<Integer> subPos : generateAllPossibleParenthesisPosition(positions.subList(i + 1, positions.size()), length - 1))
                {
                    subPos.add(positions.get(i));
                    result.add(subPos);
                }
            }
        }
        return result;
    }

    private String convertToString(ArrayList<Integer> input, int n)
    {
        char[] output = new char[n];
        int j = 0;
        for (int i = 0; i < n; i++)
        {
            if (i != input.get(j))
                output[i] = '(';
            else
            {
                output[i] = ')';
                if (j < input.size() - 1) j++;
            }
        }
        return String.valueOf(output);
    }

    private boolean checkValideParenthethis(String input)
    {
        Stack<Character> stack = new Stack<Character>();
        for (char c : input.toCharArray())
        {
            if (stack.size() == 0)
            {
                if (c == '(')
                    stack.push(c);
                else
                    return false;
            }
            else
            {
                if (c == '(')
                    stack.push(c);
                else
                    stack.pop();
            }
        }
        return stack.size() == 0;
    }
}
