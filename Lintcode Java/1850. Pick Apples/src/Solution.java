public class Solution {
    /**
     * @param A: a list of integer
     * @param K: a integer
     * @param L: a integer
     * @return: return the maximum number of apples that they can collect.
     */
    public int PickApples(int[] A, int K, int L) {
        // write your code here
        int[] preSum = new int[A.length + 1], sufSum = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            preSum[i + 1] = preSum[i] + A[i];
        }
        for (int i = A.length; i > 0; i--) {
            sufSum[i - 1] = sufSum[i] + A[i - 1];
        }
        
        int res = -1;
        // 左L右K
        res = Math.max(res, calc(A, L, K, preSum, sufSum));
        res = Math.max(res, calc(A, K, L, preSum, sufSum));
        
        return res;
    }
    
    private int calc(int[] A, int l, int r, int[] preSum, int[] sufSum) {
        int res = -1;
        for (int i = A.length - r, maxR = 0; i >= l; i--) {
            maxR = Math.max(maxR, sufSum[i] - sufSum[i + r]);
            res = Math.max(res, maxR + preSum[i] - preSum[i - l]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().PickApples(new int[]{6, 1, 4, 6, 3, 2, 7, 4}, 3, 2));
        System.out.println(new Solution().PickApples(new int[]{10, 19, 15}, 2, 2));
        System.out.println(new Solution().PickApples(new int[]{10, 19, 15, 14}, 2, 2));
        System.out.println(new Solution().PickApples(new int[]{3, 7, 6, 1, 1, 7, 7, 10, 5, 3}, 4, 2));
    }
}