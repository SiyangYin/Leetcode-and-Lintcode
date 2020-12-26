public class Solution {
    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return false;
        }
        
        boolean[] dp = new boolean[A.length];
        dp[0] = true;
    
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && j + A[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[A.length - 1];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{2, 3, 1, 1, 4}));
    }
}
