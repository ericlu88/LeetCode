package com.Eric.LeetCode.SymmetricTree;


public class Solution
{
    public boolean isSymmetric(TreeNode root)
    {
        if (root == null)
            return true;

        if ((root.left == null && root.right != null)||(root.right == null && root.left != null))
            return false;

        if (root.left == null && root.right == null)
            return true;

        // Reverse left tree
        reverseTree(root.left);

        // Check if the left tree and right tree is identical
        String preOrderLeft = PreOrderTraverse(root.left);
        String preOrderRight = PreOrderTraverse(root.right);
        String inOrderLeft = InOrderTraverse(root.left);
        String inOrderRight = InOrderTraverse(root.right);

        return (preOrderLeft.equals(preOrderRight)) && (inOrderLeft.equals(inOrderRight));
    }

    private void reverseTree(TreeNode node)
    {
        if (node.left == null && node.right == null)
            return;

        if (node.left != null) reverseTree(node.left);
        if (node.right != null) reverseTree(node.right);

        TreeNode left = node.left;

        node.left = node.right;
        node.right = left;
    }

    private String PreOrderTraverse(TreeNode node)
    {
        if (node.left == null && node.right == null)
            return Integer.toString(node.val);

        String left = node.left == null ? "" : PreOrderTraverse(node.left);
        String right = node.right == null ? "" : PreOrderTraverse(node.right);

        return Integer.toString(node.val) + left + right;
    }

    private String InOrderTraverse(TreeNode node)
    {
        if (node.left == null && node.right == null)
            return Integer.toString(node.val);

        String left = node.left == null ? "" : InOrderTraverse(node.left);
        String right = node.right == null ? "" : InOrderTraverse(node.right);

        return  left + Integer.toString(node.val) + right;
    }
}
