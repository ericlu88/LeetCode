package com.Eric.CrackingCodeInterview.Question_2_7;

/**
 * Question: Implement a function to check if a lined list is a palindrome
 */
public class Solution
{
    private boolean result;

    public boolean checkPalindrome(ListNode head)
    {
        if (head == null)
            return false;

        result = true;
        traverse(head,head);

        return result;
    }

    private ListNode traverse(ListNode backNode, ListNode head)
    {
        ListNode forwardNode = null;
        if (backNode.next != null)
            forwardNode = traverse(backNode.next, head);
        else
            forwardNode = head;

        if (result == false)
            return null;

        if (forwardNode.val != backNode.val)
        {
            result = false;
            return null;
        }

        return forwardNode.next;
    }
}
