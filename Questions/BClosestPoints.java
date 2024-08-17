package Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BClosestPoints {

    public class MyComp implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            int factorsA = getFactorsCount(a);
            int factorsB = getFactorsCount(b);

            if (factorsA == factorsB) {
                // if equal factors then compare the elments
                return a - b;
            }

            return factorsA - factorsB;

        }

        public int getFactorsCount(int n) {
            int count = 0;
            int i = 1;
            while (i * i <= n) {
                if (i * i == n) {
                    count++;
                } else if (n % i == 0) {
                    count += 2;
                }
                i++;
            }

            return count;
        }
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        MyComp myComp = new MyComp();

        Collections.sort(A, myComp);

        return A;
    }
}
