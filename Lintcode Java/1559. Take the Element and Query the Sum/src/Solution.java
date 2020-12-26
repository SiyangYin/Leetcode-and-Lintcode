public class Solution {
    /**
     * @param arr: the arr
     * @return: the sum
     */
    public int takeTheElementAndQueryTheSum(int[] arr) {
        // Write your code here
        long[] preSum = new long[arr.length + 1];
        long res = 0, MOD = (long) (1E9 + 7);
        for (int i = 0; i < arr.length; i++) {
            preSum[i + 1] = preSum[i] + arr[i];
            preSum[i + 1] %= MOD;
        }
        
        for (int i = arr.length - 1; i >= 0; i--) {
            res += arr[i] * preSum[i] % MOD;
            res %= MOD;
        }
        
        return (int) res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().takeTheElementAndQueryTheSum(new int[]{1, 2, 3, 4, 5}));
    }
}
