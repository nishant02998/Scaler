/*
Problem Description
Given an array A of length N. Also given are integers B and C.

Return 1 if there exists a subarray with length B having sum C and 0 otherwise



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 104

1 <= B <= N

1 <= C <= 109



Input Format
First argument A is an array of integers.

The remaining arguments B and C are integers



Output Format
Return 1 if such a subarray exist and 0 otherwise


Example Input
Input 1:
A = [4, 3, 2, 6, 1]
B = 3
C = 11
Input 2:

A = [4, 2, 2, 5, 1]
B = 4
C = 6


Example Output
Output 1:
1
Output 2:

0


Example Explanation
Explanation 1:
The subarray [3, 2, 6] is of length 3 and sum 11.
Explanation 2:
There are no such subarray. 
*/

//_____________________Brute Force Approach________________________
// public class Solution {
//     public int solve(int[] A, int B, int C) {
//         int n = A.length;
//         if (n < B) {
//             return 0;
//         }

//         // Creating first window
//         int s = 0;
//         int e = B - 1;

//         // Sliding window
//         while (e < n) {
//             int sum = 0;
//             for (int idx = s; idx <= e; idx++) {
//                 sum += A[idx];
//             }
//             if (sum == C) {
//                 return 1;
//             }
//             s++;
//             e++;
//         }
//         return 0;
//     }

// }

// _____________________Prefix sum Approach________________________
// public class SubarrayWithGivenSumAndLength {
//     public int solve(int[] A, int B, int C) {
//         int n = A.length;
//         int[] pfSum = new int[n];
//         pfSum[0] = A[0];
//         for (int i = 1; i < n; i++) {
//             pfSum[i] = pfSum[i - 1] + A[i];
//         }
//         int s = 0;
//         int e = B - 1;
//         while (e < n) {
//             int sum = 0;
//             if (s == 0) {
//                 sum = pfSum[e];
//             } else {
//                 sum = pfSum[e] - pfSum[s - 1];
//             }
//             s++;
//             e++;
//             if (sum == C) {
//                 return 1;
//             }
//         }
//         return 0;
//     }
// }

// ______________________Sliding window approach______________________________
public class SubarrayWithGivenSumAndLength {
    public int solve(int[] A, int B, int C) {
        int n = A.length;
        if (n < B) {
            return 0;
        }

        // Creating first window
        int s = 0;
        int e = B - 1;
        int sum = 0;

        // Finding sum of first window.
        for (int i = s; i <= e; i++) {
            sum += A[i];
            if (sum == C) {
                return 1;
            }
        }
        s++;
        e++;
        // Finding sum after sliding a window
        while (e < n) {
            sum = sum + A[e] - A[s - 1];
            if (sum == C) {
                return 1;
            }
            s++;
            e++;
        }
        return 0;
    }
}
