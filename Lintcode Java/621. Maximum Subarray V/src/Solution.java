import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    /**
     * @param nums: an array of integers
     * @param k1:   An integer
     * @param k2:   An integer
     * @return: the largest sum
     */
    public int maxSubarray5(int[] nums, int k1, int k2) {
        // write your code here
        int n = nums.length;
        if (n < k1) {
            return 0;
        }
        
        Deque<Integer> dq = new ArrayDeque<>();
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        
        int res = Integer.MIN_VALUE;
        for (int i = k1; i <= n; i++) {
            if (!dq.isEmpty() && i - dq.peekFirst() > k2) {
                dq.pollFirst();
            }
            
            while (!dq.isEmpty() && preSum[dq.peekLast()] >= preSum[i - k1]) {
                dq.pollLast();
            }
            dq.offerLast(i - k1);
            
            res = Math.max(res, preSum[i] - preSum[dq.peekFirst()]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] A = {-2, 2, -3, 4, -1, 2, 1, -5, 3};
        // int[] A = {5, -10, 4};
        System.out.println(new Solution().maxSubarray5(A, 2, 4));
    }
}
