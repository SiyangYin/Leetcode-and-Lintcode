import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    /**
     * @param A: an array
     * @return: the sum of subarray minimums
     */
    public int sumSubarrayMins(int[] A) {
        // Write your code here.
        Deque<Integer> stack = new ArrayDeque<>();
        
        int res = 0, MOD = (int) (1E9 + 7);
        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                int top = stack.pop();
                int left = top - (stack.isEmpty() ? -1 : stack.peek()), right = i - top;
                res += A[top] * left * right;
                res %= MOD;
            }

            stack.push(i);
        }
    
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int left = top - (stack.isEmpty() ? -1 : stack.peek()), right = A.length - top;
            res += A[top] * left * right;
            res %= MOD;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().sumSubarrayMins(new int[]{3, 1, 2, 4}));
    }
}
