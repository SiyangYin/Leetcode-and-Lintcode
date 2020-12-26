import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int res = 0;
        
        int[] dp = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[j] = matrix[i][j] == '0' ? 0 : dp[i] + 1;
            }
            
            res = Math.max(res, computeFromHeight(dp));
        }
        
        return res;
    }
    
    private int computeFromHeight(int[] h) {
        int res = 0;
        
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < h.length; i++) {
            while (stack.peek() != -1 && h[stack.peek()] > h[i]) {
                int top = stack.pop();
                res = Math.max(res, h[top] * (i - stack.peek() - 1));
            }
            
            stack.push(i);
        }
        
        while (stack.peek() != -1) {
            int top = stack.pop();
            res = Math.max(res, h[top] * (h.length - stack.peek() - 1));
        }
        
        return res;
    }
}
