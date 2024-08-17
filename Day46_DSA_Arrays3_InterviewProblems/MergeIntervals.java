package Day46_DSA_Arrays3_InterviewProblems;

import java.util.ArrayList;

/*
Problem Description
You have a set of non-overlapping intervals. You are given a new interval [start, end], insert this new interval into the set of intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.



Problem Constraints
0 <= |intervals| <= 105



Input Format
First argument is the vector of intervals

second argument is the new interval to be merged



Output Format
Return the vector of intervals after merging



Example Input
Input 1:

Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
Input 2:

Given intervals [1, 3], [6, 9] insert and merge [2, 6] .


Example Output
Output 1:

 [ [1, 5], [6, 9] ]
Output 2:

 [ [1, 9] ]


Example Explanation
Explanation 1:

(2,5) does not completely merge the given intervals
Explanation 2:

(2,6) completely merges the given intervals
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
public class MergeIntervals {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int n = intervals.size();
        ArrayList<Interval> ans = new ArrayList<>();
        int ns = newInterval.start;
        int ne = newInterval.end;
        // if(newInterval.start > newInterval.end) {
        // ns = newInterval.end;
        // ne = newInterval.start;
        // }
        for (int i = 0; i < n; i++) {
            int l = intervals.get(i).start;
            int r = intervals.get(i).end;
            if (ns > r) {
                ans.add(intervals.get(i));
            } else if (l > ne) {
                ans.add(new Interval(ns, ne));
                for (int j = i; j < n; j++) {
                    ans.add(intervals.get(j));
                }
                return ans;
            } else {
                ns = Math.min(ns, l);
                ne = Math.max(ne, r);
            }
        }
        ans.add(new Interval(ns, ne));
        return ans;
    }
}
