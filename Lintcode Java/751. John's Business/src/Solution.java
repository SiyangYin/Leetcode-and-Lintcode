import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    /**
     * @param A: The prices [i]
     * @param k:
     * @return: The ans array
     */
    public int[] business(int[] A, int k) {
        // Write your code here
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < Math.min(k, A.length); i++) {
            while (!deque.isEmpty() && A[deque.peekLast()] >= A[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        
        int[] res = new int[A.length];
        for (int i = 0, idx = 0, r = k; i < A.length; i++) {
            if (deque.peekFirst() < i - k) {
                deque.pollFirst();
            }
            
            if (r < A.length) {
                while (!deque.isEmpty() && A[deque.peekLast()] >= A[r]) {
                    deque.pollLast();
                }
                deque.offerLast(r);
                r++;
            }
            
            res[idx++] = A[i] - A[deque.peekFirst()];
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] A = {1, 3, 2, 1, 5};
        int k = 2;
        System.out.println(Arrays.toString(new Solution().business(A, k)));
    }
}
