import java.util.Arrays;

public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers(int[] A) {
        // write your code here
        if (A == null || A.length < 2) {
            return;
        }
    
        for (int i = 0; i < A.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[minIdx]) {
                    minIdx = j;
                }
            }
            
            swap(A, i, minIdx);
        }
    }
    
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    
    public static void main(String[] args) {
        int[] A = {3, 2, 1, 4, 5};
        new Solution().sortIntegers(A);
        System.out.println(Arrays.toString(A));
    }
}
