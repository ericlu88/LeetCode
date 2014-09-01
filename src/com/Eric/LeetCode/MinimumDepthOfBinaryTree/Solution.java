package com.Eric.LeetCode.MinimumDepthOfBinaryTree;

public class Solution
{
    private int minDepth;

    public int minDepth(TreeNode root)
    {
        if (root == null)
            return 0;

        minDepth = Integer.MAX_VALUE;
        traverse(root, 1);
        return minDepth;
    }

    private void traverse(TreeNode node, int currentLevel)
    {
        if (node.left == null && node.right == null && currentLevel < minDepth)
            minDepth = currentLevel;

        if (node.left != null)
            traverse(node.left, currentLevel + 1);
        if (node.right != null)
            traverse(node.right, currentLevel + 1);
    }
}
