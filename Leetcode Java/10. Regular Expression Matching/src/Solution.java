public class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        
        for (int j = 1; j <= m; j++) {
            for (int i = 0; i <= n; i++) {
                if (p.charAt(j - 1) != '*') {
                    f[i][j] = i > 0 && f[i - 1][j - 1] && (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1));
                } else {
                    f[i][j] = f[i][j - 2] || (i > 0 && f[i - 1][j] && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.'));
                }
            }
        }
        
        return f[n][m];
    }
}
