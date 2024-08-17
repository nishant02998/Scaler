/*
Problem Description
Given the array of strings A, you need to find the longest string S, which is the prefix of ALL the strings in the array.

The longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

Example: the longest common prefix of "abcdefgh" and "abcefgh" is "abc".



Problem Constraints
0 <= sum of length of all strings <= 1000000



Input Format
The only argument given is an array of strings A.



Output Format
Return the longest common prefix of all strings in A.



Example Input
Input 1:

A = ["abcdefgh", "aefghijk", "abcefgh"]
Input 2:

A = ["abab", "ab", "abcd"];


Example Output
Output 1:

"a"
Output 2:

"ab"


Example Explanation
Explanation 1:

Longest common prefix of all the strings is "a".
Explanation 2:

Longest common prefix of all the strings is "ab".



Expected Output
Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases
 */

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] A) {
        int n = A.length;
        int minLength = Integer.MAX_VALUE;

        // Finding min length string
        for (int i = 0; i < n; i++) {
            int len = A[i].length();
            minLength = Math.min(minLength, len);
        }

        StringBuilder str = new StringBuilder();

        // Running outer loop to 0 -> minLength-1 (0's based indexing)
        // Taking any random string here it take string at 0th indexing
        // Checking at an index i every string has a same character or not if not then
        // returning a str string.
        // Or if all strings has a same character at an index i then adding it in str
        // string
        for (int i = 0; i < minLength; i++) {
            char ch = A[0].charAt(i);
            for (int j = 1; j < n; j++) {
                if (A[j].charAt(i) != ch) {
                    return str.toString();
                }
            }
            str.append(ch);
        }
        return str.toString();
    }
}

/*
 * Second Approach using sorting
 * public class Solution {
 * public String longestCommonPrefix(String[] A) {
 * int n = A.length;
 * 
 * // Sorting an array in an increasing order
 * Arrays.sort(A);
 * 
 * //Taking first and last strings because prefix will lie in both of these
 * strings only.
 * char[] first = A[0].toCharArray();
 * char[] last = A[n-1].toCharArray();
 * StringBuilder ans = new StringBuilder();
 * 
 * /*
 * Iterating loop only through first length because it is small one and longest
 * common prefix max
 * can be of this size.
 */
// for(int i=0;i < first.length;i++) {
// if(first[i] != last[i]) {
// return ans.toString();
// }else{
// ans.append(first[i]);
// }
// }
// return ans.toString();

// }
// }

// */
