import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int shortestSubarray(int[] A, int K) {
        int[] preSum = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            preSum[i + 1] = preSum[i] + A[i];
        }
        
        Deque<Integer> deque = new ArrayDeque<>();
        
        int res = A.length + 1;
        for (int i = 0; i <= A.length; i++) {
            while (!deque.isEmpty() && preSum[i] - preSum[deque.peek()] >= K) {
                res = Math.min(res, i - deque.peek());
                deque.poll();
            }
            
            while (!deque.isEmpty() && preSum[deque.peekLast()] >= preSum[i]) {
                deque.pollLast();
            }
            
            deque.offer(i);
        }
        
        return res == A.length + 1 ? -1 : res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().shortestSubarray(new int[]{2, -1, 2}, 3));
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerFirst(3);
        
        deque.offer(1);
        deque.poll();
        System.out.println(deque);
        
    }
}
