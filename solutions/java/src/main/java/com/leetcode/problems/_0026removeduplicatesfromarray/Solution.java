package com.leetcode.problems._0026removeduplicatesfromarray;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/">Problem Link</a><br><br>
 *
 * Runtime: 1 ms (100.00%) <br>
 * Memory: 44.2 MB (88.13%)
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int x = 1;
        int k = 1;
        int last = nums[0];

        for (int i = 1; i < nums.length; i++) {
            while (nums[i] == last) {
                i++;

                if (i == nums.length) {
                    return k;
                }
            }

            nums[x] = nums[i];
            last = nums[x];
            k++;
            x++;
        }

        return k;
    }
}
