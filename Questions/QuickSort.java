package Questions;

public class QuickSort {

    public void quickSort(int[] A, int s, int e) {
        if (s < e) {
            int pivotIdx = partition(A, s, e); // will arrange the pivot element
            quickSort(A, s, pivotIdx - 1);
            quickSort(A, pivotIdx + 1, e);
        }
    }

    public int partition(int[] A, int s, int e) {
        int pivotEle = A[e];

        // we need to iterate from s to e-1
        int i = s, j = s;

        while (j < e) {
            if (A[j] <= pivotEle) {
                // swap i , j
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;
            }
            j++;
        }

        // place the pivot at i
        A[e] = A[i];
        A[i] = pivotEle;

        return i; // pivot index
    }

    public int[] solve(int[] A) {
        quickSort(A, 0, A.length - 1);
        return A;
    }
}
