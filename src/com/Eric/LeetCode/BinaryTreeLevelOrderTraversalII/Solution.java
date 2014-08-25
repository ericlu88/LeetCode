package com.Eric.LeetCode.BinaryTreeLevelOrderTraversalII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution
{
    public List<List<Integer>> levelOrderBottom(TreeNode root)
    {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)
            return result;

        Queue<ArrayList<TreeNode>> unvisited = new LinkedList<ArrayList<TreeNode>>();
        ArrayList<TreeNode> firstLevel = new ArrayList<TreeNode>();
        firstLevel.add(root);
        unvisited.add(firstLevel);
        while (!unvisited.isEmpty())
        {
            // Get the top of queue
            ArrayList<TreeNode> currentLevel = unvisited.poll();
            ArrayList<Integer> currentLevelResult = new ArrayList<Integer>();
            ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode>();
            for (TreeNode node : currentLevel)
            {
                currentLevelResult.add(node.val);
                if (node.left != null)
                    nextLevel.add(node.left);
                if (node.right != null)
                    nextLevel.add(node.right);
            }
            result.add(0, currentLevelResult);
            if (nextLevel.size() != 0)
                unvisited.add(nextLevel);
        }
        return result;
    }
}
