package com.leetcode.problems._0002addtwonumbers;

import java.util.LinkedList;

public class ListNode extends LinkedList {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
