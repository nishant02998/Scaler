package Questions;

public class pascalTriangle {

    // 0 -> 1
    // 1 -> 11
    // 2 -> 121
    // 3 -> 1331
    // 4 -> 14641

    public int[][] solve(int A) {
        int[][] C = new int[A][A]; // pascal triangle matrix
        for (int i = 0; i < A; i++) {
            C[i][0] = 1;
            C[i][i] = 1;
            for (int j = 1; j < i; j++) {
                C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
            }
        }

        return C;
    }
}
