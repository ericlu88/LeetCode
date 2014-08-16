package com.Eric.LeetCode.EvaluateReversePolishNotation;

public class Solution {
    public int evalRPN(String[] tokens)
    {
        int[] result = GetResult(tokens, tokens.length - 1);
        return result[0];
    }

    private int[] GetResult(String[] tokens, int currentIndex)
    {
        // If the current token is not operator, then it is already result
        if (!IsOperator(tokens[currentIndex]))
            return new int[] {GetNumber(tokens[currentIndex]), currentIndex};

        // Otherwise, get the right & left children's result
        int[] rightResult = GetResult(tokens, currentIndex - 1);
        int[] leftResult = GetResult(tokens, rightResult[1] - 1);

        return new int[] {Evaluate(leftResult[0], rightResult[0], tokens[currentIndex]), leftResult[1]};
    }

    private boolean IsOperator(String s)
    {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
            return true;
        return false;
    }

    private int GetNumber(String s)
    {
        int result = -200;
        try
        {
            result = Integer.parseInt(s);
        }
        catch (NumberFormatException e)
        {

        }
        return result;
    }

    private int Evaluate(int leftOperand, int rightOperand, String s)
    {
        if (s.equals("+"))
            return leftOperand + rightOperand;
        else if (s.equals("-"))
            return leftOperand - rightOperand;
        else if (s.equals("*"))
            return leftOperand * rightOperand;
        else if (s.equals("/"))
            return leftOperand / rightOperand;
        return -100;
    }
}
