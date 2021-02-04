import java.util.Arrays;

public class Solution {
    public int removeBoxes(int[] A) {
        int n = A.length;
        int[][][] f = new int[n][n][n + 1];
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int[] row : f[i]) {
                Arrays.fill(row, -1 << 30);
            }
            
            Arrays.fill(g[i], -1 << 30);
        }
        
        for (int i = 0; i < n; i++) {
            f[i][i][1] = g[i][i] = 1;
        }
        
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                f[i][j][1] = 1 + g[i + 1][j];
                g[i][j] = Math.max(g[i][j], f[i][j][1]);
                
                for (int k = 2; k <= len; k++) {
                    for (int u = i + 1; u <= j - k + 2; u++) {
                        if (A[u] != A[i]) {
                            continue;
                        }
                        
                        int t = i + 1 <= u - 1 ? g[i + 1][u - 1] : 0;
                        f[i][j][k] = Math.max(f[i][j][k], t + f[u][j][k - 1] - (k - 1) * (k - 1) + k * k);
                    }
                    
                    g[i][j] = Math.max(g[i][j], f[i][j][k]);
                }
            }
        }
        
        return g[0][n - 1];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().removeBoxes(new int[]{1, 2}));
    }
}
