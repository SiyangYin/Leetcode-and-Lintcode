public class Solution {
    /**
     * @param sales: a integer array
     * @return: return a Integer
     */
    public int BalancedSalesArray(int[] sales) {
        // write your code here
        int[] preSum = new int[sales.length + 1];
        for (int i = 0; i < sales.length; i++) {
            preSum[i + 1] = preSum[i] + sales[i];
        }
        
        for (int i = 0; i < sales.length; i++) {
            if (preSum[i] == preSum[sales.length] - preSum[i + 1]) {
                return i;
            }
        }
        
        return -1;
    }
}
