package com.Eric.LeetCode.BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)
            return result;

        ArrayList<TreeNode> currentLevel = new ArrayList<TreeNode>();
        currentLevel.add(root);
        while (currentLevel.size() > 0)
        {
            ArrayList<Integer> currentLevelValue = new ArrayList<Integer>();
            ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode>();
            for (TreeNode node : currentLevel)
            {
                currentLevelValue.add(node.val);
                if (node.left != null) nextLevel.add(node.left);
                if (node.right != null) nextLevel.add(node.right);
            }
            result.add(currentLevelValue);
            currentLevel = nextLevel;
        }
        return result;
    }
}
