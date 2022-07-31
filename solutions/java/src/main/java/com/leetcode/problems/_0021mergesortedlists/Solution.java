package com.leetcode.problems._0021mergesortedlists;

import com.leetcode.datastructures.ListNode;

/**
 * <a href="https://leetcode.com/problems/merge-two-sorted-lists/">Problem Link</a><br><br>
 *
 * Runtime: 0ms (100.00%) <br>
 * Memory: 41.7 MB (95.56%)
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // return if either of the lists are null
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        // take the lower of the two nodes and continue
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
