/*
 * Problem Description
 * You have given a string A having Uppercase English letters.
 * 
 * You have to find the number of pairs (i, j) such that A[i] = 'A', A[j] = 'G'
 * and i < j.
 * 
 * 
 * 
 * Problem Constraints
 * 1 <= length(A) <= 105
 * 
 * 
 * 
 * Input Format
 * First and only argument is a string A.
 * 
 * 
 * 
 * Output Format
 * Return an long integer denoting the answer.
 * 
 * 
 * 
 * Example Input
 * Input 1:
 * 
 * A = "ABCGAG"
 * Input 2:
 * 
 * A = "GAB"
 * 
 * 
 * Example Output
 * Output 1:
 * 
 * 3
 * Output 2:
 * 
 * 0
 * 
 * 
 * Example Explanation
 * Explanation 1:
 * 
 * Subsequence "AG" is 3 times in given string, the pairs are (0, 3), (0, 5) and
 * (4, 5).
 * Explanation 2:
 * 
 * There is no subsequence "AG" in the given string.
 */
public class countPairAG {
    public long solve(String A) {
        int length = A.length();
        long cg = 0;
        long p = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (A.charAt(i) == 'G') {
                cg = cg + 1;
            } else if (A.charAt(i) == 'A') {
                p = p + cg;
            }
        }
        return p;
    }
}
