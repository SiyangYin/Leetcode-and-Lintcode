import java.util.Arrays;

public class Solution {
    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    public void heapify(int[] A) {
        // write your code here
        for (int i = (A.length - 2) >> 1; i >= 0; i--) {
            percolateDown(A, i);
        }
    }
    
    private void percolateDown(int[] A, int i) {
        while ((i << 1) + 1 < A.length) {
            int child = (i << 1) + 1;
            
            if ((i << 1) + 2 < A.length && A[child] > A[(i << 1) + 2]) {
                child = (i << 1) + 2;
            }
            
            // child becomes the smaller child idx
            if (A[i] <= A[child]) {
                break;
            }
            
            swap(A, i, child);
            i = child;
        }
    }
    
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    
    public static void main(String[] args) {
        int[] A = new int[]{3, 2, 1, 4, 5};
        new Solution().heapify(A);
        System.out.println(Arrays.toString(A));
    }
}
