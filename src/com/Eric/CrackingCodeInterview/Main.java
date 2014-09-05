package com.Eric.CrackingCodeInterview;

import com.Eric.CrackingCodeInterview.Question_2_7.*;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Start!");

        // Build input
        ListNode zero = new ListNode(0);
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode one_2 = new ListNode(1);
        ListNode zero_2 = new ListNode(0);
        zero.next = one;
        one.next = two;
        two.next = three;
        three.next = one_2;
        one_2.next = zero_2;

        Solution solution = new Solution();
        boolean result = solution.checkPalindrome(zero);

        //System.out.println("Result: " + result);
    }
}

