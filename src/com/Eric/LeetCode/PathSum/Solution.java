package com.Eric.LeetCode.PathSum;

public class Solution
{
    public boolean hasPathSum(TreeNode root, int sum)
    {
        if (root == null)
            return false;

        return traverse(root, 0, sum);
    }

    private boolean traverse(TreeNode node, int currentSum, int targetSum)
    {
        currentSum += node.val;

        if (node.left == null && node.right == null && currentSum == targetSum)
            return true;

        boolean result = false;
        if (node.left != null)
            result = traverse(node.left, currentSum, targetSum);
        if (node.right != null && !result)
            result = traverse(node.right, currentSum,targetSum);

        return result;
    }
}
