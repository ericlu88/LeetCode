package com.Eric.LeetCode.SwapNodesInPairs;

public class Solution
{
    public ListNode swapPairs(ListNode head)
    {
        if (head == null || head.next == null)
            return head;

        ListNode p0 = null;
        ListNode p1 = head;
        ListNode p2 = head.next;

        ListNode newHead = p2;

        while(p1 != null && p2 != null)
        {
            if (p0 != null) p0.next = p2;
            p1.next = p2.next;
            p2.next = p1;

            p0 = p1;
            p1 = p1.next;
            p2 = p1 == null ? null : p1.next;
        }
        return newHead;
    }
}
