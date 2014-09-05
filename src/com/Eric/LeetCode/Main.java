package com.Eric.LeetCode;

import com.Eric.LeetCode.ValidateBinarySearchTree.*;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Start!");

        // Build input
        TreeNode N_20 = new TreeNode(20);
        TreeNode N_10 = new TreeNode(10);
        TreeNode N_30 = new TreeNode(30);
        TreeNode N_5 = new TreeNode(5);
        TreeNode N_15 = new TreeNode(15);
        TreeNode N_3 = new TreeNode(3);
        TreeNode N_7 = new TreeNode(7);
        TreeNode N_17 = new TreeNode(17);
        N_20.left = N_10;
        N_20.right = N_30;
        N_10.left = N_5;
        N_10.right = N_15;
        N_5.left = N_3;
        N_5.right = N_7;
        N_15.right = N_17;

        Solution solution = new Solution();
        boolean result = solution.isValidBST(N_20);

        //System.out.println("Result: " + result);
    }
}
