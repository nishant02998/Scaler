/*
 Problem Description
You are given a character string A having length N, consisting of only lowercase and uppercase latin letters.

You have to toggle case of each character of string A. For e.g 'A' is changed to 'a', 'e' is changed to 'E', etc.



Problem Constraints
1 <= N <= 105

A[i] ∈ ['a'-'z', 'A'-'Z']



Input Format
First and only argument is a character string A.



Output Format
Return a character string.



Example Input
Input 1:

 A = "Hello" 
Input 2:

 A = "tHiSiSaStRiNg" 


Example Output
Output 1:

 hELLO 
Output 2:

 ThIsIsAsTrInG 


Example Explanation
Explanation 1:

 'H' changes to 'h'
 'e' changes to 'E'
 'l' changes to 'L'
 'l' changes to 'L'
 'o' changes to 'O'
Explanation 2:

 "tHiSiSaStRiNg" changes to "ThIsIsAsTrInG".
 */

public class ToggleCase {
    public String solve(String A) {
        int n = A.length();
        StringBuilder ans = new StringBuilder("");
        for (int i = 0; i < n; i++) {
            char curr = A.charAt(i);
            if (curr >= 'A' && curr <= 'Z') {
                curr = (char) ('a' + (curr - 'A'));
                ans.append(curr);
            } else if (curr >= 'a' && curr <= 'z') {
                curr = (char) ('A' + (curr - 'a'));
                ans.append(curr);
            }
        }
        return ans.toString();
    }
}
