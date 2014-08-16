package com.Eric.LeetCode.BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> list = new ArrayList<Integer>();
        inorderTraversal(root, list);
        return list;
    }

    private void inorderTraversal(TreeNode node, List<Integer> list)
    {
        if (node == null)
            return;

        inorderTraversal(node.left, list);
        list.add(node.val);
        inorderTraversal(node.right,list);
    }
}
