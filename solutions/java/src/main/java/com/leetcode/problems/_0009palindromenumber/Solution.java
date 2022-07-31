package com.leetcode.problems._0009palindromenumber;

/**
 * <a href="https://leetcode.com/submissions/detail/760130523/">Problem Link</a><br><br>
 *
 * Runtime: 9ms (98.73%) <br>
 * Memory: 41.4 MB (96.59%)
 */
public class Solution {
    public boolean isPalindrome(int x) {
        String num = String.valueOf(x);

        for (int i = 0; i < num.length() / 2; i++) {
            if (num.charAt(i) != num.charAt(num.length() - 1 - i)) return false;
        }

        return true;
    }
}
