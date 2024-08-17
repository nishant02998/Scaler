package Questions;

import java.util.ArrayList;

public class seiveOfErastothenesPrime {
    public int[] solve(int A) {
        // Create Sieve
        boolean[] sieve = new boolean[A + 1]; // 0 to A

        // assuming everything is prime
        for (int i = 0; i <= A; i++) {
            sieve[i] = true;
        }

        // creation of sieve
        for (int i = 2; i * i <= A; i++) {
            if (sieve[i] == true) {
                // i is prime
                // Therefore multiples of i is not prime so mark them as false
                for (int j = i + i; j <= A; j += i) {
                    sieve[j] = false;
                }
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();
        // iterate the sieve and get prime numbers
        for (int i = 2; i <= A; i++) {
            if (sieve[i]) {
                primes.add(i);
            }
        }

        // since we have to return an array in this case
        int[] ans = new int[primes.size()];
        for (int i = 0; i < primes.size(); i++) {
            ans[i] = primes.get(i);
        }

        return ans;
    }
}
