package com.Eric.LeetCode.RemoveNthNodeFromEndOfList;

public class Solution
{
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        if (head == null)
            return head;

        ListNode p1 = head, p2 = head;
        for (int i = 0; i < n; i++)
            p2 = p2.next;

        if (p2 == null)
            return p1.next;

        while (p2.next != null)
        {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return head;
    }
}
