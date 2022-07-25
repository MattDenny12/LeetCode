package com.leetcode.problems._0003longestsubstring;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">Problem Link</a><br><br>
 *
 * Runtime: 9ms (73.50%) <br>
 * Memory: 45.1 MB (45.86%)
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> indices = new HashMap<>();
        int longestCount = 0;
        int low = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer index = indices.get(c);

            if (index != null) {
                if (low != index) {
                    cleanMap(indices, s.substring(low, index));
                }

                low = index + 1;
            }
            indices.put(c, i);

            int dif = (i + 1) - low;
            if (dif > longestCount) {
                longestCount = dif;
            }
        }

        return longestCount;
    }

    public void cleanMap(HashMap<Character, ?> map, String items) {
        for (int i = 0; i < items.length(); i++) {
            map.remove(items.charAt(i));
        }
    }
}
