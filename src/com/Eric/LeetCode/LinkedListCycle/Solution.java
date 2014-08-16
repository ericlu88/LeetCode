package com.Eric.LeetCode.LinkedListCycle;

public class Solution
{
    public boolean hasCycle(ListNode head)
    {
        if (head == null)
            return false;

        ListNode one = head;
        ListNode two = head;

        while (one.next != null && two.next != null && two.next.next != null)
        {
            one = one.next;
            two = two.next.next;
            if (one == two)
                return true;
        }
        return false;
    }
}
