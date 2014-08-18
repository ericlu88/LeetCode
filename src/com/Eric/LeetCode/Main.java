package com.Eric.LeetCode;

import com.Eric.LeetCode.MergeTwoSortedLists.*;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Start!");

        // Build input
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        one.next = three;
        three.next = five;
        two.next = four;
        four.next = six;

        Solution solution = new Solution();
        ListNode result = solution.mergeTwoLists(null, six);

        System.out.println("Result: " + result);
    }
}
