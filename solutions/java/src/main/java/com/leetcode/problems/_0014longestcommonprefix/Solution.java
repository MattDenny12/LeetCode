package com.leetcode.problems._0014longestcommonprefix;

/**
 * <a href="https://leetcode.com/problems/longest-common-prefix/">Problem Link</a><br><br>
 *
 * Runtime: 1ms (89.27%) <br>
 * Memory: 39.8 MB (99.44%)
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                String last = strs[j - 1];
                String current = strs[j];

                if (i == current.length()) {
                    return current;
                } else if (current.charAt(i) != last.charAt(i)) {
                    return current.substring(0, i);
                }
            }
        }

        return strs[0];
    }
}
