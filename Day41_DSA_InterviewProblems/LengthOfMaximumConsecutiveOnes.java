/*
Given a binary string A. It is allowed to do at most one swap between any 0 and 1. Find and return the length of the longest consecutive 1’s that can be achieved.


Input Format

The only argument given is string A.
Output Format

Return the length of the longest consecutive 1’s that can be achieved.
Constraints

1 <= length of string <= 1000000
A contains only characters 0 and 1.
For Example

Input 1:
    A = "111000"
Output 1:
    3

Input 2:
    A = "111011101"
Output 2:
    7
 */
package Day41_DSA_InterviewProblems;

public class LengthOfMaximumConsecutiveOnes {
    public int solve(String A) {
        int n = A.length();
        int totalOnes = 0;
        int maxCount = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '1') {
                totalOnes++;
            }
        }
        if (totalOnes == n) {
            return totalOnes;
        }
        for (int i = 0; i < n; i++) {
            int l = 0;
            int j = i - 1;
            while (j >= 0 && A.charAt(j) == '1') {
                l++;
                j--;
            }
            int r = 0;
            int k = i + 1;
            while (k < n && A.charAt(k) == '1') {
                r++;
                k++;
            }
            if (l + r == totalOnes) {
                maxCount = l + r;
            } else {
                maxCount = l + r + 1;
            }
            if (ans < maxCount) {
                ans = maxCount;
            }
        }
        return ans;
    }
}
