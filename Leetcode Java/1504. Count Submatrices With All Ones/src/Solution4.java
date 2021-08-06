import java.util.Deque;
import java.util.LinkedList;

public class Solution4 {
    public int numSubmat(int[][] mat) {
        for (int i = 1; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] += mat[i - 1][j];
                }
            }
        }
        
        int res = 0;
        for (int[] row : mat) {
            res += compute(row);
        }
        
        return res;
    }
    
    private int compute(int[] h) {
        int res = 0;
        Deque<int[]> stk = new LinkedList<>();
        for (int i = 0; i < h.length; i++) {
            int s = 0;
            while (!stk.isEmpty() && h[stk.peek()[0]] >= h[i]) {
                stk.pop();
            }
            
            if (!stk.isEmpty()) {
                s += (i - stk.peek()[0]) * h[i];
                s += stk.peek()[1];
            } else {
                s += (i + 1) * h[i];
            }
            
            stk.push(new int[]{i, s});
            res += s;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] mat = {
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 1, 1, 0}};
        System.out.println(new Solution4().numSubmat(mat));
    }
}
