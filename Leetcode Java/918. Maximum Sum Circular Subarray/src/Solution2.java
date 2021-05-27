public class Solution2 {
    public int maxSubarraySumCircular(int[] A) {
        int curMaxSum = 0, curMinSum = 0, total = 0, minSum = Integer.MAX_VALUE, maxSum = Integer.MIN_VALUE;
        for (int x : A) {
            curMaxSum = Math.max(x, x + curMaxSum);
            curMinSum = Math.min(x, x + curMinSum);
            minSum = Math.min(minSum, curMinSum);
            maxSum = Math.max(maxSum, curMaxSum);
            total += x;
        }
        
        return maxSum >= 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().maxSubarraySumCircular(new int[]{-2, -3, -1}));
    }
}
