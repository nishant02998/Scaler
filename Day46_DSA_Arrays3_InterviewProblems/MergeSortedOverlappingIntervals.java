package Day46_DSA_Arrays3_InterviewProblems;

import java.util.ArrayList;

/*
Problem Description
Given a collection of sorted intervals, merge all overlapping intervals.



Problem Constraints
1 <= Total number of intervals <= 100000.



Input Format
First argument is a list of intervals.



Output Format
Return the sorted list of intervals after merging all the overlapping intervals.



Example Input
Input 1:

[1,3],[2,6],[8,10],[15,18]


Example Output
Output 1:

[1,6],[8,10],[15,18]


Example Explanation
Explanation 1:

Merge intervals [1,3] and [2,6] -> [1,6].
so, the required answer after merging is [1,6],[8,10],[15,18].
No more overlapping intervals present.
 */
/**
 * Definition for an interval.
 * public class Interval {
 * int start;
 * int end;
 * Interval() { start = 0; end = 0; }
 * Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MergeSortedOverlappingIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> ans = new ArrayList<>();
        int n = intervals.size();
        Interval interval = intervals.get(0);
        int curr_start = interval.start;
        int curr_end = interval.end;
        for (int i = 1; i < n; i++) {
            Interval ith = intervals.get(i);
            int ith_start = ith.start;
            int ith_end = ith.end;
            if (ith_start <= curr_end) {
                curr_start = Math.min(ith_start, curr_start);
                curr_end = Math.max(ith_end, curr_end);
            } else {
                ans.add(new Interval(curr_start, curr_end));
                curr_start = ith_start;
                curr_end = ith_end;
            }
        }
        ans.add(new Interval(curr_start, curr_end));
        return ans;
    }
}
