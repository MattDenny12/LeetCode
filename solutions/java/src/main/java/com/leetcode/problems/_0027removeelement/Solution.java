package com.leetcode.problems._0027removeelement;

/**
 * <a href="https://leetcode.com/problems/remove-element/">Problem Link</a><br><br>
 *
 * Runtime: 0ms (100.00%) <br>
 * Memory: 42.8 MB (25.47%)
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        // pointers for the start and "end" of the array
        int i = 0;
        int n = nums.length;

        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }

        return n;
    }
}
