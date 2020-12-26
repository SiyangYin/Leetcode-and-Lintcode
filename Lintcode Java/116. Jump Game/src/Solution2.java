public class Solution2 {
    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return false;
        }
        
        int farthest = 0;
        for (int i = 0; i < A.length; i++) {
            if (i <= farthest) {
                farthest = Math.max(farthest, i + A[i]);
            }
        }
        
        return farthest >= A.length - 1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().canJump(new int[]{2, 3, 1, 1, 4}));
    }
}
