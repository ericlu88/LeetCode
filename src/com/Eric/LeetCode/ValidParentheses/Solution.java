package com.Eric.LeetCode.ValidParentheses;

import java.util.ArrayList;

public class Solution
{
    public boolean isValid(String s)
    {
        if (s == null || s.equals(""))
            return false;

        ArrayList<Character> stack = new ArrayList<Character>();
        for (char c : s.toCharArray())
        {
            if (c == '(' || c == '{' || c == '[')
                stack.add(c);
            else if (c == ')' || c == '}' || c == ']')
            {
                if (c == ')')
                {
                    if (stack.size() == 0)
                        return false;
                    if (stack.get(stack.size() - 1) == '(')
                        stack.remove(stack.size() - 1);
                    else
                        return false;
                }
                else if (c == '}')
                {
                    if (stack.size() == 0)
                        return false;
                    if (stack.get(stack.size() - 1) == '{')
                        stack.remove(stack.size() - 1);
                    else
                        return false;
                }
                else
                {
                    if (stack.size() == 0)
                        return false;
                    if (stack.get(stack.size() - 1) == '[')
                        stack.remove(stack.size() - 1);
                    else
                        return false;
                }
            }
            else
                return false;
        }
        return stack.size() == 0;
    }
}
