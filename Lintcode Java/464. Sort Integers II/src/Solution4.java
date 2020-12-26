import java.util.Arrays;

public class Solution4 {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here
        mergeSort(A, 0, A.length - 1, new int[A.length]);
    }
    
    private void mergeSort(int[] A, int l, int r, int[] tmp) {
        if (l >= r) {
            return;
        }
        
        int m = l + (r - l >> 1);
        mergeSort(A, l, m, tmp);
        mergeSort(A, m + 1, r, tmp);
        
        int i = l, j = m + 1, idx = 0;
        while (i <= m && j <= r) {
            if (A[i] <= A[j]) {
                tmp[idx++] = A[i++];
            } else {
                tmp[idx++] = A[j++];
            }
        }
        
        while (i <= m) {
            tmp[idx++] = A[i++];
        }
        while (j <= r) {
            tmp[idx++] = A[j++];
        }
    
        idx = 0;
        for (int k = l; k <= r; k++) {
            A[k] = tmp[idx++];
        }
    }
    
    public static void main(String[] args) {
        int[] A = {3, 2, 1, 4, 5};
        new Solution4().sortIntegers2(A);
        System.out.println(Arrays.toString(A));
    }
}
