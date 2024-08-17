package Day42_DSA_Arrays1_OneDimentional;

/*
 * Problem Description
 * Given a vector A of non-negative integers representing an elevation map where
 * the width of each bar is 1, compute how much water it is able to trap after
 * raining.
 * 
 * 
 * 
 * Problem Constraints
 * 1 <= |A| <= 100000
 * 
 * 
 * 
 * Input Format
 * First and only argument is the vector A
 * 
 * 
 * 
 * Output Format
 * Return one integer, the answer to the question
 * 
 * 
 * 
 * Example Input
 * Input 1:
 * 
 * A = [0, 1, 0, 2]
 * Input 2:
 * 
 * A = [1, 2]
 * 
 * 
 * Example Output
 * Output 1:
 * 
 * 1
 * Output 2:
 * 
 * 0
 * 
 * 
 * Example Explanation
 * Explanation 1:
 * 
 * 1 unit is trapped on top of the 3rd element.
 * Explanation 2:
 * 
 * No water is trapped.
 */
/*
 * public class RainWaterTapping {
 * // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
 * public static int max(int lmax, int ht) {
 * if (lmax > ht) {
 * return lmax;
 * } else {
 * return ht;
 * }
 * }
 * 
 * public int trap(final int[] A) {
 * int n = A.length;
 * int i = 0;
 * int j = n - 1;
 * int lmax = A[i];
 * int rmax = A[n - 1];
 * int water = 0;
 * int ans = 0;
 * while (i < j) {
 * if (lmax < rmax) {
 * i++;
 * water = lmax - A[i];
 * lmax = max(lmax, A[i]);
 * } else {
 * j--;
 * water = rmax - A[j];
 * rmax = max(rmax, A[j]);
 * }
 * if (water > 0) {
 * ans += water;
 * }
 * }
 * return ans;
 * }
 * }
 */
public class RainWaterTapping {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int trap(final int[] A) {
        int n = A.length;
        int left = 0;
        int right = n - 1;
        int leftMax = A[left];
        int rightMax = A[right];
        int sum = 0;
        while (left < right) {
            int water = 0;
            if (A[left] <= A[right]) {
                if (A[left] > leftMax) {
                    leftMax = A[left];
                    water = leftMax - A[left];
                    left++;
                } else {
                    water = leftMax - A[left];
                    left++;
                }
            } else {
                if (A[right] > rightMax) {
                    rightMax = A[right];
                    water = rightMax - A[right];
                    right--;
                } else {
                    water = rightMax - A[right];
                    right--;
                }
            }
            if (water > 0) {
                sum += water;
            }
        }
        return sum;
    }
}

/*
 * Prefix Max and Suffix Max Approach
 * public class Solution {
 * // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
 * public int trap(final int[] A) {
 * int n = A.length;
 * int[] pfLeftMax = new int[n];
 * int[] pfRightMax = new int[n];
 * pfLeftMax[0] = A[0];
 * pfRightMax[n-1] = A[n-1];
 * for(int i=1;i < n;i++) {
 * if(pfLeftMax[i-1] < A[i]) {
 * pfLeftMax[i] = A[i];
 * }else {
 * pfLeftMax[i] = pfLeftMax[i-1];
 * }
 * }
 * for(int i=n-2;i >= 0;i--) {
 * if(pfRightMax[i+1] < A[i]) {
 * pfRightMax[i] = A[i];
 * }else {
 * pfRightMax[i] = pfRightMax[i+1];
 * }
 * }
 * int sum = 0;
 * for(int i=0;i < n;i++) {
 * int leftMax = pfLeftMax[i];
 * int rightMax = pfRightMax[i];
 * int min = Math.min(leftMax,rightMax);
 * int water = min - A[i];
 * sum += water;
 * }
 * return sum;
 * }
 * }
 * 
 */