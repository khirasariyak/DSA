package Greedy;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
* https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
* */

public class G7_NMeetingInOneRoom {

    public int maxMeetings(int[] start, int[] end) {

        List<AbstractMap.SimpleEntry<Integer, Integer>> meetings = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            meetings.add(new AbstractMap.SimpleEntry<>(start[i], end[i]));
        }

        // sort by endTime
        meetings.sort(Map.Entry.comparingByValue());

        int count = 1;
        int prevMeetingEndTime = meetings.getFirst().getValue();

        for (int i = 1; i < meetings.size(); i++) {
            AbstractMap.SimpleEntry<Integer, Integer> currentMeeting = meetings.get(i);
            if (currentMeeting.getKey() > prevMeetingEndTime) {
                count++;
                prevMeetingEndTime = currentMeeting.getValue();
            }
        }

        return count;
    }

}
