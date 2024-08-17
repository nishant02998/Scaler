/*
Problem Description
You are given an array A of N integers.
Return a 2D array consisting of all the subarrays of the array

Note : The order of the subarrays in the resulting 2D array does not matter.


Problem Constraints
1 <= N <= 100
1 <= A[i] <= 105


Input Format
First argument A is an array of integers.


Output Format
Return a 2D array of integers in any order.


Example Input
Input 1:
A = [1, 2, 3]
Input 2:
A = [5, 2, 1, 4]


Example Output
Output 1:
[[1], [1, 2], [1, 2, 3], [2], [2, 3], [3]]
Output 2:
[[1 ], [1 4 ], [2 ], [2 1 ], [2 1 4 ], [4 ], [5 ], [5 2 ], [5 2 1 ], [5 2 1 4 ] ]


Example Explanation
For Input 1:
All the subarrays of the array are returned. There are a total of 6 subarrays.
For Input 2:
All the subarrays of the array are returned. There are a total of 10 subarrays. 
*/

public class generateAllSubarrays {
    public int[][] solve(int[] A) {
        int size = A.length; // 4bytes
        int total = (size * (size + 1)) / 2; // 4bytes // Count of total sub arrays
        int[][] subArrays = new int[total][]; // 8nbytes// Declaration of 2D array for all sub arrays
        int j = 0; // 4byes // 2D array rows variable
        for (int s = 0; s < size; s++) {
            // setting start index of sub array
            for (int e = s; e < size; e++) {
                // setting end index of sub array
                int len = e - s + 1; // 4bytes // length of each sub array
                int[] singleSubArray = new int[len]; // 4n bytes// Declaration of 1D array for each sub array
                int start = s; // 4bytes
                int end = e; // 4bytes
                for (int i = 0; i < len; i++) {
                    if (start <= end) {
                        singleSubArray[i] = A[start];
                        start++;
                    }
                }
                subArrays[j] = singleSubArray; // Adding each sub array into 2D array on row index 'j';
                j++; // Increasing 2D array row index.
            }
        }
        return subArrays;
    }
}

// Time Complexity = O(n^3)
// Space Complexity = 2n
