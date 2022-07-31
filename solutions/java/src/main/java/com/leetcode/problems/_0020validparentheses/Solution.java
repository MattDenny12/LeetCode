package com.leetcode.problems._0020validparentheses;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/valid-parentheses/">Problem Link</a><br><br>
 *
 * Runtime: 1ms (99.61%) <br>
 * Memory: 40.4 MB (89.15%)
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> paren = new Stack<>();

        char[] chars = s.toCharArray();

        for (char c : chars) {
            switch(c) {
                case '(': case '{': case '[':
                    paren.add(c);
                    break;
                case ')':
                    if (paren.isEmpty() || paren.pop() != '(') return false;
                    break;
                case '}':
                    if (paren.isEmpty() || paren.pop() != '{') return false;
                    break;
                case ']':
                    if (paren.isEmpty() || paren.pop() != '[') return false;
                    break;
            }
        }

        return paren.isEmpty();
    }
}
