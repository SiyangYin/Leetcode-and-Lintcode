public class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] f = new int[n][n];
        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                char ch1 = s.charAt(l), ch2 = s.charAt(r);
                if (len == 2) {
                    f[l][r] = ch1 == ch2 ? 0 : 1;
                } else  {
                    if (ch1 == ch2) {
                        f[l][r] = f[l + 1][r - 1];
                    } else {
                        f[l][r] = Math.min(f[l + 1][r], f[l][r - 1]) + 1;
                    }
                }
            }
        }
        
        return f[0][n - 1];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minInsertions("zzazz"));
        System.out.println(new Solution().minInsertions("mbadm"));
    }
}
