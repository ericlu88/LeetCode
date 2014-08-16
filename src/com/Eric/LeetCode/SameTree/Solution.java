package com.Eric.LeetCode.SameTree;

public class Solution
{
    public boolean isSameTree(TreeNode p, TreeNode q)
    {
        return !((p == null && q != null) || (p != null && q == null)) && (p == null && q == null || TraverseTwoTree(p, q));
    }

    private boolean TraverseTwoTree(TreeNode p, TreeNode q)
    {
        // Check current node value
        if (p.val != q.val)
            return false;

        // Check left child tree
        if ((p.left != null && q.left == null) || (p.left == null && q.left != null))
            return false;
        if (p.left != null && q.left != null && !TraverseTwoTree(p.left, q.left))
            return false;

        // Check right child tree
        if ((p.right != null && q.right == null) || (p.right == null && q.right != null))
            return false;
        if (p.right != null && q.right != null && !TraverseTwoTree(p.right, q.right))
            return false;

        return true;
    }
}
