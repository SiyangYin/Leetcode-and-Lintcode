public class Solution {
    /**
     * @param A: An array of integers
     * @return: An integer
     */
    public int firstMissingPositive(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 1;
        }
    
        for (int i = 0; i < A.length; i++) {
            while (1 <= A[i] && A[i] <= A.length && A[A[i] - 1] != A[i]) {
                swap(A, A[i] - 1, i);
            }
        }
    
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        
        return A.length + 1;
    }
    
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().firstMissingPositive(new int[]{3, 4, -1, 1}));
    }
}
