public class Solution {
    /**
     * @param A: a matrix
     * @return: the resulting image
     */
    public int[][] flipAndInvertImage(int[][] A) {
        // Write your code here
        for (int i = 0; i < A.length; i++) {
            reverse(A[i]);
            for (int j = 0; j < A[0].length; j++) {
                A[i][j] ^= 1;
            }
        }
        
        return A;
    }
    
    private void reverse(int[] nums) {
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
