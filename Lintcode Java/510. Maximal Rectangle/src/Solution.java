import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    /**
     * @param matrix: a boolean 2D matrix
     * @return: an integer
     */
    public int maximalRectangle(boolean[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int res = 0;
        int[] dp = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!matrix[i][j]) {
                    dp[j] = 0;
                } else {
                    if (i > 0) {
                        dp[j] += 1;
                    } else {
                        dp[j] = 1;
                    }
                }
            }
            
            res = Math.max(res, compute(dp));
        }
        
        return res;
    }
    
    private int compute(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                int top = stack.pop();
                res = Math.max(res, heights[top] * (i - stack.peek() - 1));
            }
            
            stack.push(i);
        }
        
        while (stack.peek() != -1) {
            int top = stack.pop();
            res = Math.max(res, heights[top] * (heights.length - stack.peek() - 1));
        }
        
        return res;
    }
}
