/*
Problem Description

Given an integer array A of length N. Print array of numbers in which each element is sum of a subarray.
Problem Constraints

1 <= N <= 1000
1 <= A[i] <= 105
Input Format

First line is N, size of array
Next line contains N integers
Output Format

Print single line containing subarray sums separated by space
Example Input

Input 1:
3
11 12 6
Input 2:
5
10 27 12 25 24
Example Output

Output 1:
11 23 29 12 18 6
Output 2:
10 37 49 74 98 27 39 64 88 12 37 61 25 49 24
Example Explanation

Explanation 1:
Sum of subarray 11 is 11
Sum of subarray 11, 12 is 23
Sum of subarray 11, 12, 6 is 29
Sum of subarray 12 is 12
Sum of subarray 12, 6 is 18
Sum of subarray 6 is 6 
*/

import java.util.*;

public class SubarraysSum {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        for (int s = 0; s < n; s++) {
            for (int e = s; e < n; e++) {
                int sum = 0;
                for (int i = s; i <= e; i++) {
                    sum = sum + array[i];
                }
                System.out.print(sum + " ");
            }
        }

    }
}
