package com.leetcode.problems._0366findleaves;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/find-leaves-of-binary-tree/submissions/">Problem Link</a><br><br>
 *
 * Runtime: 0ms (100.00%) <br>
 * Memory: 40.6 MB (95.35%)
 */
public class Solution {

    List<List<Integer>> leafLayers = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {

        removeLeaves(root);

        // remove the root once all leaves have been removed
        root = null;

        return leafLayers;
    }

    /**
     * Helper method for finding the leaves of a binary tree and removing them.
     *
     * @param n The node that we will be removing the leaves from.
     * @return the height of TreeNode n;
     */
    public int removeLeaves(TreeNode n) {
        if (n == null) {
            return -1;
        }

        // find the height of the current node
        int height = 1 + Math.max(removeLeaves(n.left), removeLeaves(n.right));

        // add a new layer to the leaf list if it doesn't exist for this height
        if (leafLayers.size() == height) {
            leafLayers.add(new ArrayList<>());
        }

        // add the current node to the leaf list at its respective height
        leafLayers.get(height).add(n.val);

        // remove the leaves
        n.left = null;
        n.right = null;

        return height;
    }
}
