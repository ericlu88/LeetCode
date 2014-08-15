package com.Eric.LeetCode.RemoveDuplicatesFromSortedList;

public class Solution
{
    public ListNode deleteDuplicates(ListNode head)
    {
        if (head == null || head.next == null)
            return head;

        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null)
        {
            p2 = p2.next;
            while (p2 != null && p2.val <= p1.val)
            {
                p1.next = p2.next;
                p2.next = null;
                p2 = p1.next;
            }
            p1 = p2;
        }
        return head;
    }
}
