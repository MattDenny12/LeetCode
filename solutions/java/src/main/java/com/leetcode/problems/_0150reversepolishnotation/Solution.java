package com.leetcode.problems._0150reversepolishnotation;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation/">Problem Link</a><br><br>
 *
 * Runtime: 5 ms (97.43%) <br>
 * Memory: 42.3 MB (96.79%)
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        // Loop through each token and perform the appropriate operations
        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    // Grab the RHS first since that will be the value at the top of the stack
                    int rhs = stack.pop();
                    int lhs = stack.pop();

                    stack.push(lhs + rhs);
                }
                case "-" -> {
                    int rhs = stack.pop();
                    int lhs = stack.pop();

                    stack.push(lhs - rhs);
                }
                case "*" -> {
                    int rhs = stack.pop();
                    int lhs = stack.pop();

                    stack.push(lhs * rhs);
                }
                case "/" -> {
                    int rhs = stack.pop();
                    int lhs = stack.pop();

                    stack.push(lhs / rhs);
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }

        // The final result will be the last value on the stack
        return stack.pop();
    }
}
