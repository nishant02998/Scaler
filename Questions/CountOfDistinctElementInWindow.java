package Questions;

import java.util.ArrayList;
import java.util.HashMap;

public class CountOfDistinctElementInWindow {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        int n = A.size();
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();

        // Sliding window
        // starting index of first window -> [0 to k-1]
        // 1. We should initialize the first window
        for (int i = 0; i < B; i++) {
            if (freq.containsKey(A.get(i))) {
                int count = freq.get(A.get(i));
                freq.put(A.get(i), count + 1);
            } else {
                freq.put(A.get(i), 1);
            }
        }
        ans.add(freq.size()); // answer of the first window

        // for rest of the windows
        // [1,k] -> second window
        // [n-k, n-1] -> last window
        int s = 1, e = B;
        while (e < n) {
            // for every window
            // reduce freq s-1 element and incr freq e element

            // s-1 element
            if (freq.get(A.get(s - 1)) == 1) {
                freq.remove(A.get(s - 1));
            } else {
                int count = freq.get(A.get(s - 1));
                freq.put(A.get(s - 1), count - 1);
            }

            // e element
            if (freq.containsKey(A.get(e))) {
                // increase the freq
                int count = freq.get(A.get(e));
                freq.put(A.get(e), count + 1);
            } else {
                freq.put(A.get(e), 1);
            }

            // get answer for this window
            ans.add(freq.size());

            s++;
            e++;
        }

        return ans;
    }
}
