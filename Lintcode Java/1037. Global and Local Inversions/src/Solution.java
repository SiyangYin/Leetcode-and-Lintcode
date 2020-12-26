public class Solution {
    /**
     * @param A: an array
     * @return: is the number of global inversions is equal to the number of local inversions
     */
    public boolean isIdealPermutation(int[] A) {
        // Write your code here
        for (int i = 0; i < A.length; i++) {
            if (Math.abs(A[i] - i) >= 2) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isIdealPermutation(new int[]{2, 0, 3, 1}));
    }
}
