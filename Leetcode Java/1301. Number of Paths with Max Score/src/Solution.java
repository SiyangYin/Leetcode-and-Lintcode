import java.util.List;

public class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int m = board.size(), n = board.get(0).length();
        int[][] f = new int[m][n], g = new int[m][n];
        g[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = board.get(i).charAt(j);
                if (ch != 'X') {
                    int x = i == m - 1 && j == n - 1 ? 0 : ch - '0';
                    if (i >= 1 && board.get(i - 1).charAt(j) != 'X') {
                        update(x, i, j, i - 1, j, f, g);
                    }
                    if (j >= 1 && board.get(i).charAt(j - 1) != 'X') {
                        update(x, i, j, i, j - 1, f, g);
                    }
                    if (i >= 1 && j >= 1 && board.get(i - 1).charAt(j - 1) != 'X') {
                        update(x, i, j, i - 1, j - 1, f, g);
                    }
                }
            }
        }
        
        return new int[]{f[m - 1][n - 1], g[m - 1][n - 1]};
    }
    
    private void update(int cur, int i, int j, int pi, int pj, int[][] f, int[][] g) {
        if (g[pi][pj] == 0) {
            return;
        }
        
        if (cur + f[pi][pj] > f[i][j]) {
            f[i][j] = cur + f[pi][pj];
            g[i][j] = g[pi][pj];
        } else if (cur + f[pi][pj] == f[i][j]) {
            g[i][j] = (int) ((g[i][j] + g[pi][pj]) % (1e9 + 7));
        }
    }
}
