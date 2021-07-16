public class Solution2 {
    public int countPalindromicSubsequences(String s) {
        int n = s.length(), MOD = (int) (1e9 + 7);
        int[][] f = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            f[i][i] = 1;
        }
        
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) != s.charAt(j)) {
                    f[i][j] = f[i][j - 1] + f[i + 1][j] - f[i + 1][j - 1];
                } else {
                    f[i][j] = f[i + 1][j - 1] << 1;
                    int l = i + 1, r = j - 1;
                    while (l <= r && s.charAt(l) != s.charAt(j)) {
                        l++;
                    }
                    while (l <= r && s.charAt(r) != s.charAt(j)) {
                        r--;
                    }
                    
                    if (l > r) {
                        f[i][j] += 2;
                    } else if (l == r) {
                        f[i][j]++;
                    } else {
                        f[i][j] -= f[l + 1][r - 1];
                    }
                }
    
                f[i][j] = f[i][j] < 0 ? f[i][j] + MOD : f[i][j] % MOD;
            }
        }
        
        return f[0][n - 1];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().countPalindromicSubsequences("bccb"));
        System.out.println(new Solution2().countPalindromicSubsequences("abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba"));
        System.out.println((int) 1e9 + 7);
        System.out.println((int) 1e9 + 7 + -485074175);
    }
}
