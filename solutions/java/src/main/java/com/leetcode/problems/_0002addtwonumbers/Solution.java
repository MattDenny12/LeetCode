package com.leetcode.problems._0002addtwonumbers;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null;
        ListNode last = null;

        // We want to continue to create new nodes so long as l1/l2 have some value or there is still some carry over
        while (!(l1 == null && l2 == null) || carry != 0) {
            int sum = value(l1) + value(l2) + carry;

            // If the sum is greater than 10, then we need to carry over some value to the next magnitude
            if (sum >= 10) {
                int mod = sum % 10;
                carry = (sum - mod) / 10;
                sum = mod;
            } else {
                carry = 0;
            }

            // create the next node in the linked list
            ListNode node = new ListNode(sum);
            if (last != null) {
                last.next = node;
            } else {
                head = node;
            }
            last = node;

            l1 = next(l1);
            l2 = next(l2);
        }

        return head;
    }

    public ListNode next(ListNode n) {
        return n == null ? null : n.next;
    }

    public int value(ListNode n) {
        return n == null ? 0 : n.val;
    }
}
