/*
Problem Description
You are given an integer array C of size A. Now you need to find a subarray (contiguous elements) so that the sum of contiguous elements is maximum.
But the sum must not exceed B.


Problem Constraints
1 <= A <= 103
1 <= B <= 109
1 <= C[i] <= 106


Input Format
The first argument is the integer A.
The second argument is the integer B.
The third argument is the integer array C.


Output Format
Return a single integer which denotes the maximum sum.


Example Input
Input 1:
A = 5
B = 12
C = [2, 1, 3, 4, 5]
Input 2:

A = 3
B = 1
C = [2, 2, 2]


Example Output
Output 1:
12
Output 2:

0


Example Explanation
Explanation 1:
We can select {3,4,5} which sums up to 12 which is the maximum possible sum.
Explanation 2:

All elements are greater than B, which means we cannot select any subarray.
Hence, the answer is 0. 
*/

public class MaximumSubarrayEasy {
    public int maxSubarray(int A, int B, int[] C) {
        int[] pfSum = new int[A];
        int max = 0;
        pfSum[0] = C[0];
        for (int i = 1; i < A; i++) {
            pfSum[i] = pfSum[i - 1] + C[i];
        }
        for (int s = 0; s < A; s++) {
            for (int e = s; e < A; e++) {
                int sum = 0;
                if (s == 0) {
                    sum = pfSum[e];
                } else {
                    sum = pfSum[e] - pfSum[s - 1];
                }
                if (sum <= B) {
                    max = maxValue(max, sum);
                }

            }
        }
        return max;
    }

    public static int maxValue(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
}

// _____________________________________________________________________________

// public class MaximumSubarrayEasy {
//     public int maxSubarray(int A, int B, int[] C) {
//         int n = A;
//         int ans = 0;
//         for (int s = 0; s < n; s++) {
//             int sum = 0;
//             for (int e = s; e < n; e++) {
//                 sum += C[e];
//                 if (sum <= B) {
//                     ans = Math.max(ans, sum);
//                 }
//             }
//         }
//         return ans;
//     }
// }
