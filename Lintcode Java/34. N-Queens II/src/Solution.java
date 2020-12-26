public class Solution {
    
    int res = 0;
    
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    public int totalNQueens(int n) {
        // write your code here
        
        dfs(n, 0, new int[n], new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]);
        return res;
    }
    
    private void dfs(int n, int cur, int[] pos, boolean[] col, boolean[] diag, boolean[] adiag) {
        if (cur == n) {
            res++;
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (!col[i] && !diag[cur + i] && !adiag[n - i + cur - 1]) {
                pos[cur] = i;
                col[i] = diag[cur + i] = adiag[n - i + cur - 1] = true;
                dfs(n, cur + 1, pos, col, diag, adiag);
                col[i] = diag[cur + i] = adiag[n - i + cur - 1] = false;
            }
        }
    }
}
