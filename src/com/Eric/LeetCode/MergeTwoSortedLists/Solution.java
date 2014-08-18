package com.Eric.LeetCode.MergeTwoSortedLists;

public class Solution
{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode l1Current = l1;
        ListNode l2Current = l2;
        ListNode newCurrent = null;
        ListNode newHead = null;

        while (l1Current != null || l2Current != null)
        {
            if (l1Current == null)
            {
                if (newCurrent == null)
                {
                    newCurrent = l2Current;
                    newHead = newCurrent;
                }
                else
                    newCurrent.next = l2Current;
                break;
            }
            else if (l2Current == null)
            {
                if (newCurrent == null)
                {
                    newCurrent = l1Current;
                    newHead = newCurrent;
                }
                else
                    newCurrent.next = l1Current;
                break;
            }
            else
            {
                if (l1Current.val > l2Current.val)
                {
                    if (newCurrent == null)
                    {
                        newCurrent = l2Current;
                        newHead = newCurrent;
                    }
                    else
                    {
                        newCurrent.next = l2Current;
                        newCurrent = newCurrent.next;
                    }
                    l2Current = l2Current.next;
                }
                else
                {
                    if (newCurrent == null)
                    {
                        newCurrent = l1Current;
                        newHead = newCurrent;
                    }
                    else
                    {
                        newCurrent.next = l1Current;
                        newCurrent = newCurrent.next;
                    }
                    l1Current = l1Current.next;
                }
            }
        }
        return newHead;
    }
}
