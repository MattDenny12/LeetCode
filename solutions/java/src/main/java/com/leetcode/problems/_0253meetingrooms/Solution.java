package com.leetcode.problems._0253meetingrooms;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/logger-rate-limiter/">Problem Link</a><br><br>
 *
 * Runtime: 9ms (69.29%) <br>
 * Memory: 43 MB (84.59%)
 */
public class Solution {
    /** We don't really need this class, but it will help keep things organized and easy to read. */
    private static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int minMeetingRooms(int[][] intervals) {
        // Create our priority queue with the desired Comparator
        PriorityQueue<Meeting> meetingQueue = new PriorityQueue<>((m1, m2) -> {
            if (m1.start < m2.start) {
                return -1;
            } else if (m1.start > m2.start) {
                return 1;
            } else {
                return Integer.compare(m2.end, m1.end);
            }
        });

        // Sort the meetings by start time
        for (int[] interval : intervals) {
            Meeting currentMeeting = new Meeting(interval[0], interval[1]);
            meetingQueue.add(currentMeeting);
        }

        int count = 0;
        LinkedList<Meeting> ongoingMeetings = new LinkedList<>();

        // Go through each meeting in order of start time
        while (!meetingQueue.isEmpty()) {
            Meeting currentMeeting = meetingQueue.poll();

            // Check to see if an ongoing meeting can be removed
            ongoingMeetings.removeIf(ongoing -> ongoing.end <= currentMeeting.start);
            // Add the current meeting to the list of "ongoing" meetings
            ongoingMeetings.add(currentMeeting);

            if (ongoingMeetings.size() > count) {
                count = ongoingMeetings.size();
            }
        }

        return count;
    }
}