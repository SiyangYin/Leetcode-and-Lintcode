public class Solution {
    /**
     * @param customers: the number of customers
     * @param grumpy: the owner's temper every day
     * @param X: X days
     * @return: calc the max satisfied customers
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        // write your code here
        int n = customers.length;
        int[] preSum = new int[n + 1], lSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + customers[i];
            lSum[i + 1] = lSum[i];
            if (grumpy[i] == 0) {
                lSum[i + 1] += customers[i];
            }
        }
        
        if (X >= n) {
            return preSum[n + 1];
        }
        
        int res = 0;
        for (int i = 0; i <= n - X; i++) {
            res = Math.max(res, lSum[i] + (preSum[i + X] - preSum[i]) + lSum[n] - lSum[i + X]);
        }
    
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().maxSatisfied(
                new int[]{1, 0, 1, 2, 1, 1, 7, 5},
                new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
    }
}
