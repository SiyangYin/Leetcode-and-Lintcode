public class Solution {
    public int distinctSubseqII(String s) {
        int n = s.length(), MOD = (int) (1e9 + 7);
        int[] pos = new int[26];
        long[] f = new long[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            char ch = s.charAt(i - 1);
            f[i] = f[i - 1] * 2 % MOD;
            if (pos[ch - 'a'] > 0) {
                f[i] = (f[i] - f[pos[ch - 'a'] - 1] + MOD) % MOD;
            }
            
            pos[ch - 'a'] = i;
        }
        
        return (int) (f[n] - 1);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().distinctSubseqII("abc"));
        System.out.println(new Solution().distinctSubseqII("aba"));
    }
}
