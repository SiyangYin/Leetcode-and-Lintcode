import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    /**
     * @param matrix: a matrix
     * @return: Number of submatrices that are all 0
     */
    public long countSubmatrix(int[][] matrix) {
        // write your code here
        int m = matrix.length, n = matrix[0].length;
    
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 1;
                    if (i > 0) {
                        dp[i][j] += dp[i - 1][j];
                    }
                }
            }
        }
        
        long res = 0;
        for (int i = 0; i < m; i++) {
            res += calculate(dp[i]);
        }
        
        return res;
    }
    
    private long calculate(int[] height) {
        long count = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < height.length; i++) {
            while (stack.peek() != -1 && height[stack.peek()] > height[i]) {
                int top = stack.pop();
                
                int h = stack.peek() == -1 ? height[top] - height[i] : height[top] - Math.max(height[stack.peek()], height[i]);
                int w = i - stack.peek() - 1;
                count += h * (w + 1) * w / 2;
            }
            stack.push(i);
        }
        
        while (stack.peek() != -1) {
            int top = stack.pop();
            int h = stack.peek() == -1 ? height[top] : height[top] - height[stack.peek()];
            int w = height.length - stack.peek() - 1;
            count += h * (w + 1) * w / 2;
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        int[][] mat = {
                {0, 1, 1},
                {1, 1, 1},
                {1, 0, 1}};
        int res = 0;
        for (int x1 = 0; x1 < mat.length; x1++) {
            for (int y1 = 0; y1 < mat[0].length; y1++) {
                for (int x2 = 0; x2 < mat.length; x2++) {
                    for (int y2 = 0; y2 < mat[0].length; y2++) {
                        if (x2 >= x1 && y2 >= y1) {
                            
                            boolean b = true;
                            for (int i = x1; i <= x2; i++) {
                                for (int j = y1; j <= y2; j++) {
                                    if (mat[i][j] == 1) {
                                        b = false;
                                    }
                                }
                            }
                            
                            if (b) {
                                res++;
                            }
                        }
                    }
                }
                
            }
        }
        
        System.out.println(res);
        
        System.out.println(new Solution().countSubmatrix(mat));
    }
}