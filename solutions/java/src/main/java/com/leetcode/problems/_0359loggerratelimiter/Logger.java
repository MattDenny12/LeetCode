package com.leetcode.problems._0359loggerratelimiter;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/logger-rate-limiter/">Problem Link</a><br><br>
 *
 * Runtime: 32ms (91.95%) <br>
 * Memory: 50.2 MB (94.78%)
 */
public class Logger {
    private final HashMap<String, Integer> messageTimes;

    public Logger() {
        messageTimes = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (messageTimes.containsKey(message)) {
            if (messageTimes.get(message) + 10 <= timestamp) {
                messageTimes.put(message, timestamp);
                return true;
            }

            return false;
        }

        messageTimes.put(message, timestamp);
        return true;
    }
}
