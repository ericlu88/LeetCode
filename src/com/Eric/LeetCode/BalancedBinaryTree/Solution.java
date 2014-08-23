package com.Eric.LeetCode.BalancedBinaryTree;

public class Solution
{
    public boolean isBalanced(TreeNode root)
    {
        if (root == null)
            return true;

        return GetHeight(root) >= 0;
    }

    private int GetHeight(TreeNode node)
    {
        // If this is leaf, then the height is one
        if (node.left == null && node.right == null)
            return 1;

        // Else, get the height of left and right node, and plus 1 will be the height of this level
        int leftHeight = node.left == null ? 0 : GetHeight(node.left);
        int rightHeight = node.right == null ? 0 : GetHeight(node.right);

        if (leftHeight < 0 || rightHeight < 0)
            return -1;

        // Use -1 as indicator that the tree is in-balanced at this level, thus the entire tree is not a balanced tree
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
