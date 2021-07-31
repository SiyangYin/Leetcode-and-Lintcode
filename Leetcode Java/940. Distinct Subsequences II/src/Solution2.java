public class Solution2 {
    public int distinctSubseqII(String s) {
        int n = s.length(), MOD = (int) (1e9 + 7);
        int[][] dfa = new int[n + 1][26];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                dfa[i][j] = dfa[i + 1][j];
            }
            dfa[i][s.charAt(i) - 'a'] = i + 1;
        }
        
        return dfs(0, dfa, MOD, new int[n + 1]) - 1;
    }
    
    private int dfs(int u, int[][] dfa, int MOD, int[] f) {
        if (f[u] > 0) {
            return f[u];
        }
    
        f[u] = 1;
        for (int i = 0; i < 26; i++) {
            if (dfa[u][i] > 0) {
                f[u] = (f[u] + dfs(dfa[u][i], dfa, MOD, f)) % MOD;
            }
        }
        
        return f[u];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().distinctSubseqII("abc"));
        System.out.println(new Solution2().distinctSubseqII("aba"));
    }
}
