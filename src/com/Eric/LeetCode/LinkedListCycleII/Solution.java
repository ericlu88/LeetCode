package com.Eric.LeetCode.LinkedListCycleII;

public class Solution
{
    // Note: Linked list could have cycle anywhere, doesn't have to be connect to the head
    public ListNode detectCycle(ListNode head)
    {
        if (head == null)
            return null;

        ListNode p1 = head, p2 = head;
        boolean hasCycle = false;
        while (p1.next != null && p2.next != null && p2.next.next != null)
        {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2)
            {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle)
            return null;
        p1 = head;
        while (p1 != p2)
        {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
