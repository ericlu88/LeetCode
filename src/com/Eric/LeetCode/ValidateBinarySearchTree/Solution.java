package com.Eric.LeetCode.ValidateBinarySearchTree;

public class Solution
{
    public boolean isValidBST(TreeNode root)
    {
        if (root == null)
            return true;

        TempResult result = traverse(root);
        return result.IsBalanced;
    }

    private TempResult traverse(TreeNode node)
    {
        if (node.left == null && node.right == null)
            return new TempResult(node.val, node.val, true);

        TempResult left = null, right = null;
        if (node.left != null)
            left = traverse(node.left);
        if (left != null && !left.IsBalanced)
            return left;
        if (node.right != null)
            right = traverse(node.right);
        if (right != null && !right.IsBalanced)
            return right;

        if ((left == null || (left != null && left.Max < node.val)) && (right == null || (right != null && node.val < right.Min)))
        {
            int min = left == null ? node.val : left.Min;
            int max = right == null ? node.val : right.Max;
            return new TempResult(min, max, true);
        }
        else
            return new TempResult(0,0,false);
    }

    public class TempResult
    {
        public int Min;
        public int Max;
        public boolean IsBalanced;

        public TempResult(int MIN, int MAX, boolean ISBALANCED)
        {
            Min = MIN;
            Max = MAX;
            IsBalanced = ISBALANCED;
        }
    }
}
