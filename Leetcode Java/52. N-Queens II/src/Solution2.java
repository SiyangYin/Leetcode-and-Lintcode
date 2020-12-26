public class Solution2 {
    
    int count = 0;
    
    public int totalNQueens(int n) {
        dfs(new int[n], new boolean[2 * n - 1], new boolean[2 * n - 1], new boolean[n], 0, n);
        return count;
    }
    
    private void dfs(int[] path, boolean[] dg, boolean[] udg, boolean[] col, int row, int n) {
        if (row == n) {
            count++;
            return;
        }
    
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dg[row + i] && !udg[n - 1 - i + row]) {
                path[row] = i;
                dg[row + i] = udg[n - 1 - i + row] = col[i] = true;
                dfs(path, dg, udg, col, row + 1, n);
                dg[row + i] = udg[n - 1 - i + row] = col[i] = false;
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().totalNQueens(8));
    }
}
