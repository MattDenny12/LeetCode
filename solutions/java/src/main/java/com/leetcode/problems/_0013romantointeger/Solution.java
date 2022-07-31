package com.leetcode.problems._0013romantointeger;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/roman-to-integer/">Problem Link</a><br><br>
 *
 * Runtime: 6ms (85.67%) <br>
 * Memory: 42.7 MB (90.14%)
 */
public class Solution {
    HashMap<Character, Integer> roman = new HashMap<>();
    HashMap<Character, Character> sub = new HashMap<>();

    public int romanToInt(String s) {
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        sub.put('V', 'I');
        sub.put('X', 'I');
        sub.put('L', 'X');
        sub.put('C', 'X');
        sub.put('D', 'C');
        sub.put('M', 'C');

        return parseRoman(s.toCharArray(), s.length() - 1);
    }

    public int parseRoman(char[] chars, int index) {
        if (index < 0) {
            return 0;
        } else if (index == 0) {
            return roman.get(chars[index]);
        }

        char cur = chars[index];
        char next = chars[index - 1];

        if (sub.get(cur) != null && sub.get(cur) == next) {
            return (roman.get(cur) - roman.get(next)) + parseRoman(chars, index - 2);
        }

        return roman.get(cur) + parseRoman(chars, index - 1);
    }
}
