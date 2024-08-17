/*
 * Problem Description
Given a string A of size N, find and return the longest palindromic substring in A.

Substring of string A is A[i...j] where 0 <= i <= j < len(A)

Palindrome string:
A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.

Incase of conflict, return the substring which occurs first ( with the least starting index).



Problem Constraints
1 <= N <= 6000



Input Format
First and only argument is a string A.



Output Format
Return a string denoting the longest palindromic substring of string A.



Example Input
Input 1:
A = "aaaabaaa"
Input 2:
A = "abba


Example Output
Output 1:
"aaabaaa"
Output 2:
"abba"


Example Explanation
Explanation 1:
We can see that longest palindromic substring is of length 7 and the string is "aaabaaa".
Explanation 2:
We can see that longest palindromic substring is of length 4 and the string is "abba".
 */

public class LongestPalindromicSubstring {
    public String longestPalindrome(String A) {
        int n = A.length();
        int maxLength = 0;
        String ans = "";
        int start = 0;
        int end = 0;

        // Even length Palindrome
        for (int c = 0; c < n; c++) {
            int left = c;
            int right = c + 1;
            while (left >= 0 && right < n) {
                if (A.charAt(left) != A.charAt(right)) {
                    break;
                } else {
                    if (right - left + 1 > maxLength) {
                        maxLength = right - left + 1;
                        start = left;
                        end = right;
                    }
                    left--;
                    right++;
                }
            }
        }

        // Odd length Palindrome
        for (int c = 0; c < n; c++) {
            int left = c;
            int right = c;
            while (left >= 0 && right < n) {
                if (A.charAt(left) != A.charAt(right)) {
                    break;
                } else {
                    if (right - left + 1 > maxLength) {
                        maxLength = right - left + 1;
                        start = left;
                        end = right;
                    }
                    left--;
                    right++;
                }
            }
        }
        // System.out.println(end);
        // System.out.println(start);
        for (int i = start; i <= end; i++) {
            ans = ans + A.charAt(i);
        }
        return ans;
    }

    public static int maxValue(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static boolean isPalindrome(String str, int l, int r) {
        int s = l;
        int e = r;
        while (s <= e) {
            if (str.charAt(s) != str.charAt(e)) {
                return false;
            } else {
                s++;
                e--;
            }
        }
        return true;
    }
}
