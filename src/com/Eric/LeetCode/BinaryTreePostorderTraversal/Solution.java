package com.Eric.LeetCode.BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public List<Integer> postorderTraversal(TreeNode root)
    {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;

        traversal(root,result);
        return result;
    }

    private void traversal(TreeNode node, List<Integer> result)
    {
        if (node.left != null)  traversal(node.left,result);
        if (node.right != null)  traversal(node.right,result);
        result.add(node.val);
    }
}
