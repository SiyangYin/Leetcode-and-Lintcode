import java.util.Arrays;

public class Solution {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] f = new int[n][n][n + 1];
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int[] row : f[i]) {
                Arrays.fill(row, Integer.MIN_VALUE / 2);
            }
            
            Arrays.fill(g[i], Integer.MIN_VALUE / 2);
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
                        if (boxes[u] != boxes[i]) {
                            continue;
                        }
                        
                        int l = 0;
                        if (i + 1 <= u - 1) {
                            l = g[i + 1][u - 1];
                        }
                        f[i][j][k] = Math.max(f[i][j][k], l + f[u][j][k - 1] - (k - 1) * (k - 1) + k * k);
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
