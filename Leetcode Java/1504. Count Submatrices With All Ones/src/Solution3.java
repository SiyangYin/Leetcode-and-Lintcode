import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution3 {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] += mat[i - 1][j];
                }
            }
        }
        
        // System.out.println(Arrays.deepToString(mat));
        
        int res = 0;
        for (int i = 0; i < m; i++) {
            int count = calculate(mat[i]);
            res += count;
        }
        
        return res;
    }
    
    private int calculate(int[] h) {
        int res = 0;
        Deque<Integer> stk = new ArrayDeque<>();
        stk.push(-1);
        for (int i = 0; i < h.length; i++) {
            while (stk.peek() != -1 && h[stk.peek()] >= h[i]) {
                int top = stk.pop();
                
                int height = 0;
                if (stk.peek() != -1) {
                    height = h[top] - Math.max(h[i], h[stk.peek()]);
                } else {
                    height = h[top] - h[i];
                }
                
                int width = i - stk.peek() - 1;
                res += height * (width + 1) * width / 2;
            }
            
            stk.push(i);
        }
        
        while (stk.peek() != -1) {
            int top = stk.pop();
            
            int height = 0;
            if (stk.peek() != -1) {
                height = h[top] - h[stk.peek()];
            } else {
                height = h[top];
            }
            
            int width = h.length - stk.peek() - 1;
            res += height * (width + 1) * width / 2;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] mat = {
                {0, 1},
                {1, 1},
                {1, 0}};
        int[][] mat2 = {
                {0, 1},
                {1, 1},
                {1, 0}};
        
        System.out.println(Arrays.deepToString(mat));
        
        System.out.println(new Solution3().numSubmat(mat));
        System.out.println(new Solution().numSubmat(mat2));
        
        int[][] mm = {{1,1,1},{1,1,1},{1,1,1}};
        System.out.println(new Solution3().numSubmat(mm));
    }
}
