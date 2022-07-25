package com.leetcode.problems._0001twosum;

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Key is the number and value is the index
        HashMap<Integer, Integer> deltaMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int delta = target - nums[i];
            Integer deltaIndex = deltaMap.get(delta);

            // If the delta is not in the map, then we can put it into the map and continue
            if (deltaIndex == null) {
                deltaMap.put(nums[i], i);
                continue;
            }

            // If the delta was in the map, then we have our two numbers that make up the target
            return new int[]{deltaIndex, i};
        }

        return null;
    }
}
