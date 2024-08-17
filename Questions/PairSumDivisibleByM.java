
package Questions;

public class PairSumDivisibleByM {
    public int solve(int[] A, int B) {
        int n = A.length;
        // 0 to B - 1
        int[] freq = new int[B];
        int count = 0;
        int mod = 1000000007;

        for (int i = 0; i < n; i++) {
            int first = A[i] % B;
            if (first == 0) {
                // 0 will pair with 0
                count = (count + freq[0]) % mod;
            } else {
                int second = B - first;
                count = (count + freq[second]) % mod;
            }

            freq[first] = freq[first] + 1;
        }

        return count;
    }
}
