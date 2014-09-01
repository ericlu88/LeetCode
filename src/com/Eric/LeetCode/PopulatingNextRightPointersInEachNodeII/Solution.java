package com.Eric.LeetCode.PopulatingNextRightPointersInEachNodeII;

public class Solution
{
    public void connect(TreeLinkNode root)
    {
        if (root == null)
            return;

        TreeLinkNode currentLevelFirstNode = root;
        TreeLinkNode currentNode;
        TreeLinkNode nextNode;
        while (currentLevelFirstNode != null)
        {
            currentNode = currentLevelFirstNode;
            currentLevelFirstNode = null;
            while (currentNode != null)
            {
                if (currentNode.left == null && currentNode.right == null)
                {
                    currentNode = currentNode.next;
                    continue;
                }

                if (currentNode.left != null && currentNode.right != null)
                {
                    currentNode.left.next = currentNode.right;
                    if (currentLevelFirstNode == null)
                        currentLevelFirstNode = currentNode.left;
                }
                if (currentNode.right != null)
                {
                    if (currentLevelFirstNode == null)
                        currentLevelFirstNode = currentNode.right;
                }
                else
                {
                    if (currentLevelFirstNode == null)
                        currentLevelFirstNode = currentNode.left;
                }

                nextNode = currentNode.next;
                while (nextNode != null && nextNode.left == null && nextNode.right == null)
                    nextNode = nextNode.next;
                if (nextNode == null)
                {
                    currentNode = null;
                    continue;
                }

                if (currentNode.right != null)
                {
                    if (nextNode.left != null)
                        currentNode.right.next = nextNode.left;
                    else
                        currentNode.right.next = nextNode.right;

                }
                else
                {
                    if (nextNode.left != null)
                        currentNode.left.next = nextNode.left;
                    else
                        currentNode.left.next = nextNode.right;
                }
                currentNode = nextNode;
            }
        }
    }
}
