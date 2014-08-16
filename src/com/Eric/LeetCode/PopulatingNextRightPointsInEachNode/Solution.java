package com.Eric.LeetCode.PopulatingNextRightPointsInEachNode;

// I didn't think out this question! Look at others code!!
public class Solution
{
    public void connect(TreeLinkNode root)
    {
        if (root == null)
            return;

        TreeLinkNode p1 = root;
        TreeLinkNode p2 = root;

        while (p1.left != null)
        {
            while (p2 != null)
            {
                p2.left.next = p2.right;
                if (p2.next != null)
                    p2.right.next = p2.next.left;
                p2 = p2.next;
            }
            p1 = p1.left;
            p2=p1;
        }
    }
}
