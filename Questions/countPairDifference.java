package Questions;

import java.util.HashMap;

public class countPairDifference {
    public int solve(int[] A, int B) {
        int n = A.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        int count = 0;
        int mod = 1000000007;

        // a - b = k -> b = a - k
        // b - a = k -> b = k + a
        for (int i = 0; i < n; i++) {
            int target1 = A[i] - B;
            int target2 = B + A[i];

            int freq1 = 0;
            int freq2 = 0;
            if (freq.containsKey(target1)) {
                freq1 = freq.get(target1);
            }
            if (freq.containsKey(target2)) {
                freq2 = freq.get(target2);
            }
            count = (count + freq1 + freq2) % mod;

            // update the element freq in map
            if (freq.containsKey(A[i])) {
                freq.put(A[i], freq.get(A[i]) + 1);
            } else {
                freq.put(A[i], 1);
            }
        }

        return count;
    }
}
