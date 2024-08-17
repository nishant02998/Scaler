/*
Problem Description
Given an array A of size N, find the subarray of size B with the least average.



Problem Constraints
1 <= B <= N <= 105
-105 <= A[i] <= 105


Input Format
First argument contains an array A of integers of size N.
Second argument contains integer B.


Output Format
Return the index of the first element of the subarray of size B that has least average.
Array indexing starts from 0.


Example Input
Input 1:
A = [3, 7, 90, 20, 10, 50, 40]
B = 3
Input 2:

A = [3, 7, 5, 20, -10, 0, 12]
B = 2


Example Output
Output 1:
3
Output 2:

4


Example Explanation
Explanation 1:
Subarray between indexes 3 and 5
The subarray {20, 10, 50} has the least average 
among all subarrays of size 3.
Explanation 2:

 Subarray between [4, 5] has minimum average 
*/

//___________________Brute Force____________________________
/*
public class Solution {
    public int solve(int[] A, int B) {
       int n = A.length;
       int[] pfSum = new int[n];
       pfSum[0] = A[0];
       for(int i=1;i < n;i++) {
           pfSum[i] = pfSum[i-1] + A[i];
       }
       double minAvg = Double.MAX_VALUE; // Changed to double for precision
       int minIndex = 0;
       for(int s=0;s < n;s++) {
           int subArraySum = 0;
           for(int e=s;e < n;e++) {
               if(s == 0) {
                   subArraySum = pfSum[e];
               }else {
                   subArraySum = pfSum[e] - pfSum[s-1];
               }
               int len = e-s+1;
               if(len == B) {
                   double avg = subArraySum / (double)B; // Calculate average with double precision
                   if(avg < minAvg) {
                       minAvg = avg;
                       minIndex = s;
                   }
               }
           }
       }
        return minIndex;
    }
}
 
*/

//_____________________________Sliding Window__________________________________
public class SubArrayWithLeastAverage {
    public int solve(int[] A, int B) {
        int n = A.length;
        int[] pfSum = new int[n];
        pfSum[0] = A[0];
        for (int i = 1; i < n; i++) {
            pfSum[i] = pfSum[i - 1] + A[i];
        }
        double minAvg = Double.MAX_VALUE;
        int minIndex = 0;
        // Creating first window
        int s = 0;
        int e = B - 1;
        while (e < n) {
            int subArraySum = 0;
            if (s == 0) {
                subArraySum = pfSum[e];
            } else {
                subArraySum = pfSum[e] - pfSum[s - 1];
            }
            double avg = subArraySum / (double) B;
            if (minAvg > avg) {
                minAvg = avg;
                minIndex = s;
            }
            s++;
            e++;
        }
        return minIndex;
    }
}
