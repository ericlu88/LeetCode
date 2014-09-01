package com.Eric.LeetCode.FlattenBinaryTreeToLinkedList;

public class Solution
{
    private TreeNode mostRightNode;

    public void flatten(TreeNode root)
    {
        if (root == null)
            return;

        mostRightNode = null;

        traverse(root);
    }

    private void traverse(TreeNode node)
    {
        if (mostRightNode == null)
            mostRightNode = node;
        else
        {
            mostRightNode.right = node;
            mostRightNode = node;
        }

        if (node.left == null && node.right == null)
            return;

        if (node.left != null && node.right != null)
        {
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            traverse(node.right);
            traverse(node.left);
            node.left = null;
            return;
        }

        if (node.left != null && node.right == null)
        {
            traverse(node.left);
            node.left = null;
            return;
        }

        if (node.right != null && node.left == null)
        {
            traverse(node.right);
            return;
        }
    }
}
