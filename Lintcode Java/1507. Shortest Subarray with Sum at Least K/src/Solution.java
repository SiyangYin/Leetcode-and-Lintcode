import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    /**
     * @param A: the array
     * @param K: sum
     * @return: the length
     */
    public int shortestSubarray(int[] A, int K) {
        // Write your code here.
        if (A == null || A.length == 0) {
            return -1;
        }
        
        Deque<Integer> deque = new ArrayDeque<>();
        int[] preSum = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            preSum[i + 1] = preSum[i] + A[i];
        }
    
        int res = A.length + 1;
        for (int i = 0; i < preSum.length; i++) {
            while (!deque.isEmpty() && preSum[i] - preSum[deque.peek()] >= K) {
                res = Math.min(res, i - deque.peek());
                deque.poll();
            }
            
            while (!deque.isEmpty() && preSum[deque.peekLast()] >= preSum[i]) {
                deque.pollLast();
            }
            
            deque.offer(i);
        }
        
        return res <= A.length ? res : -1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().shortestSubarray(new int[]{1, 2}, 4));
    }
}
