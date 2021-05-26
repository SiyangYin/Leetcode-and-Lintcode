import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int[] preSum = new int[A.length * 2 + 1];
        for (int i = 0; i < A.length * 2; i++) {
            preSum[i + 1] = preSum[i] + A[i % A.length];
        }
        
        int res = Integer.MIN_VALUE;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < preSum.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - A.length) {
                deque.pollFirst();
            }
            
            if (!deque.isEmpty()) {
                res = Math.max(res, preSum[i] - preSum[deque.peekFirst()]);
            }
            
            while (!deque.isEmpty() && preSum[deque.peekLast()] >= preSum[i]) {
                deque.pollLast();
            }
            
            deque.offerLast(i);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().maxSubarraySumCircular(new int[]{1, -2, 3}));
    }
}
