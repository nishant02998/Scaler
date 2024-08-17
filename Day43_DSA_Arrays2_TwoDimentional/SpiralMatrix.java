package Day43_DSA_Arrays2_TwoDimentional;

/*
Problem Description
Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order and return the generated square matrix.



Problem Constraints
1 <= A <= 1000



Input Format
First and only argument is integer A


Output Format
Return a 2-D matrix which consists of the elements added in spiral order.



Example Input
Input 1:

1
Input 2:

2
Input 3:

5


Example Output
Output 1:

[ [1] ]
Output 2:

[ [1, 2], 
  [4, 3] ]
Output 2:

[ [1,   2,  3,  4, 5], 
  [16, 17, 18, 19, 6], 
  [15, 24, 25, 20, 7], 
  [14, 23, 22, 21, 8], 
  [13, 12, 11, 10, 9] ]


Example Explanation
Explanation 1:

Only 1 is to be arranged.
Explanation 2:

1 --> 2
      |
      |
4<--- 3
Explanation 3:


 */
/*
 public class Solution {
    public int[][] generateMatrix(int A) {
        int[][] ans = new int[A][A];
        int n = A;
        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = n-1;
        int num = 1;
        while(top <= bottom && left <= right) {
            for(int i=left;i <= right;i++) {
                ans[top][i] = num;
                num++;
            }
            top++;
            for(int i=top;i <= bottom;i++) {
                ans[i][right] = num;
                num++;
            }
            right--;
            if(top <= bottom) {
                for(int i=right;i >= left;i--) {
                    ans[bottom][i] = num;
                    num++;
                }
                bottom--;
            }
            if(left <= right) {
                for(int i=bottom;i >= top;i--) {
                    ans[i][left] = num;
                    num++;
                }
                left++;
            }
        }
        return ans;
    }
}

 */
public class SpiralMatrix {
    public int[][] generateMatrix(int A) {
        int[][] arr = new int[A][A];
        int i = 0;
        int j = 0;
        int val = 1;
        while (A > 1) {
            for (int cnt = 1; cnt <= A - 1; cnt++) {
                arr[i][j] = val;
                j++;
                val++;
            }
            for (int cnt = 1; cnt <= A - 1; cnt++) {
                arr[i][j] = val;
                val++;
                i++;
            }
            for (int cnt = 1; cnt <= A - 1; cnt++) {
                arr[i][j] = val;
                val++;
                j--;
            }
            for (int cnt = 1; cnt <= A - 1; cnt++) {
                arr[i][j] = val;
                val++;
                i--;
            }
            A = A - 2;
            i++;
            j++;
        }
        if (A == 1) {
            arr[i][j] = val;
        }
        return arr;
    }
}
