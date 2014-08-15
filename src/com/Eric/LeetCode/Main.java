package com.Eric.LeetCode;

import com.Eric.LeetCode.ClimbingStairs.Solution;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Start!");

        // Build input
        int input = 35;

        Solution solution = new Solution();
        int result = solution.climbStairs(input);

        System.out.println("Result: " + result);
    }
}
