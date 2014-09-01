package com.Eric.LeetCode.SumRootToLeafNumbers;

public class Solution
{
    public int result;

    public int sumNumbers(TreeNode root)
    {
        result = 0;
        if (root == null)
            return result;

        traverse(root, 0);

        return result;
    }

    private void traverse(TreeNode node, int runningSum)
    {
        runningSum = runningSum * 10 + node.val;

        if (node.left == null && node.right == null)
            result += runningSum;

        if (node.left != null)
            traverse(node.left, runningSum);
        if (node.right != null)
            traverse(node.right, runningSum);
    }
}
