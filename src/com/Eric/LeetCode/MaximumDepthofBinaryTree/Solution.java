package com.Eric.LeetCode.MaximumDepthofBinaryTree;

public class Solution
{
    public static int maxLevel;

    public static int maxDepth(TreeNode root)
    {
        if (root == null)
            return 0;

        maxLevel = 0;
        TraverseTree(root, 1);
        return maxLevel;
    }

    private static void TraverseTree(TreeNode root, int currentLevel)
    {
        // If this is leaf level, find out if the current level is more than max level
        if (root.left == null && root.right == null && currentLevel > maxLevel)
        {
            maxLevel = currentLevel;
            return;
        }

        // Otherwise, traverse the left and right tree
        if (root.left != null) TraverseTree(root.left, currentLevel + 1);
        if (root.right != null) TraverseTree(root.right, currentLevel + 1);
    }
}
