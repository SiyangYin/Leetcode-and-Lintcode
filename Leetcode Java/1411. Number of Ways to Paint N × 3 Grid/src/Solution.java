public class Solution {
    public int numOfWays(int n) {
        int MOD = (int) (1e9 + 7);
        long[][] f = new long[2][2];
        f[1][0] = f[1][1] = 6;
        for (int i = 2; i <= n; i++) {
            f[i & 1][0] = (f[i - 1 & 1][0] * 3 + f[i - 1 & 1][1] * 2) % MOD;
            f[i & 1][1] = (f[i - 1 & 1][0] * 2 + f[i - 1 & 1][1] * 2) % MOD;
        }
        
        return (int) ((f[n & 1][0] + f[n & 1][1]) % MOD);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().numOfWays(5));
    }
}
