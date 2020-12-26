import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    public List<List<String>> solveNQueens(int n) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        if (n == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        
        dfs(n, 0, new int[n], new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], res);
        
        return res;
    }
    
    private void dfs(int n, int cur, int[] pos, boolean[] col, boolean[] diag, boolean[] adiag, List<List<String>> res) {
        if (cur == n) {
            res.add(buildBoard(pos, n));
            return;
        }
    
        for (int i = 0; i < n; i++) {
            if (!col[i] && !diag[cur + i] && !adiag[n - i + cur - 1]) {
                pos[cur] = i;
                col[i] = diag[cur + i] = adiag[n - i + cur - 1] = true;
                dfs(n, cur + 1, pos, col, diag, adiag, res);
                col[i] = diag[cur + i] = adiag[n - i + cur - 1] = false;
            }
        }
    }
    
    private List<String> buildBoard(int[] pos, int n) {
        List<String> rows = new ArrayList<>();
        for (int i = 0; i < pos.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (pos[i] != j) {
                    sb.append('.');
                } else {
                    sb.append('Q');
                }
            }
            rows.add(sb.toString());
        }
        
        return rows;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(4));
    }
}
