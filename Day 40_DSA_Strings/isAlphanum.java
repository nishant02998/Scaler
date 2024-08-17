/*
Problem Description
You are given a function isalpha() consisting of a character array A.

Return 1 if all the characters of a character array are alphanumeric (a-z, A-Z, and 0-9) else, return 0.



Problem Constraints
1 <= |A| <= 105



Input Format
Only argument is a character array A.



Output Format
Return 1 if all the characters of the character array are alphanumeric (a-z, A-Z and 0-9), else return 0.



Example Input
Input 1:

 A = ['S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0']
Input 2:

 A = ['S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0']


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 All the characters are alphanumeric.
Explanation 2:

 All the characters are NOT alphabets i.e ('#').
 */

public class isAlphanum {
    public int solve(char[] A) {
        int n = A.length;
        boolean isValid = true;
        for (int i = 0; i < n; i++) {
            char ch = A[i];
            if (ch >= 65 && ch <= 90) {
                isValid = true;
            } else if (ch >= 97 && ch <= 122) {
                isValid = true;
            } else if (ch >= 48 && ch <= 57) {
                isValid = true;
            } else {
                isValid = false;
                return 0;
            }
        }
        if (isValid) {
            return 1;
        } else {
            return 0;
        }
    }
}
