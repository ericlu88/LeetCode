package com.Eric.LeetCode;

import com.Eric.LeetCode.GrayCode.*;

import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Start!");

        // Build input
        int input = 2;

        Solution solution = new Solution();
        List<Integer> result = solution.grayCode(input);

        //System.out.println("Result: " + result);
    }
}
