package com.Eric.LeetCode.BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public List<Integer> preorderTraversal(TreeNode root)
    {
        List<Integer> list = new ArrayList<Integer>();
        preorderTraversal(root, list);
        return list;
    }

    private void preorderTraversal(TreeNode node, List<Integer> list)
    {
        if (node == null)
            return;

        list.add(node.val);
        preorderTraversal(node.left, list);
        preorderTraversal(node.right,list);
    }
}
