package com.Eric.LeetCode.ConvertSortedArraytoBinarySearchTree;

public class Solution
{
    public TreeNode sortedArrayToBST(int[] num)
    {
        if (num == null || num.length == 0)
            return null;

        return BuildTree(num, 0, num.length - 1, treeSide.left);
    }

    private TreeNode BuildTree(int[] num, int startingIndex, int endingIndex, treeSide side)
    {
        // If only one left, This is the entire tree
        if (startingIndex == endingIndex)
            return new TreeNode(num[startingIndex]);

        // If there are two left, then create the tree by the order
        if (endingIndex - startingIndex == 1)
        {
            TreeNode small = new TreeNode(num[startingIndex]);
            TreeNode big = new TreeNode(num[endingIndex]);
            if (side == treeSide.left)
            {
                big.left = small;
                return big;
            }
            else
            {
                small.right = big;
                return small;
            }
        }

        // Otherwise, build left & right tree accordingly
        int midIndex = (startingIndex + endingIndex) / 2;
        TreeNode current = new TreeNode(num[midIndex]);
        if (midIndex - 1 >= startingIndex) current.left = BuildTree(num, startingIndex, midIndex - 1, treeSide.left);
        if (endingIndex >= midIndex + 1) current.right = BuildTree(num, midIndex + 1, endingIndex, treeSide.right);

        return current;
    }

    enum treeSide
    {
        left,
        right
    }
}
