package Day41_DSA_InterviewProblems;

/*
Problem Description
Given an array of size N, find the majority element. The majority element is the element that appears more than floor(n/2) times.
You may assume that the array is non-empty and the majority element always exists in the array.



Problem Constraints
1 <= N <= 5*105
1 <= num[i] <= 109


Input Format
Only argument is an integer array.


Output Format
Return an integer.


Example Input
Input 1:
[2, 1, 2]
Input 2:
[1, 1, 1]


Example Output
Input 1:
2
Input 2:
1


Example Explanation
For Input 1:
2 occurs 2 times which is greater than 3/2.
For Input 2:
 1 is the only element in the array, so it is majority
 */
public class MajorityElement1 {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int majorityElement(final int[] A) {
        int n = A.length;
        int majIndex = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                majIndex = i;
                count = 1;
            } else {
                if (A[majIndex] == A[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (A[majIndex] == A[i]) {
                cnt++;
            }
        }
        if (cnt > n / 2) {
            return A[majIndex];
        }
        return -1;
    }
}
