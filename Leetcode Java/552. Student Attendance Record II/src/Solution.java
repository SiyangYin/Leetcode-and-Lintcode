public class Solution {
    public int checkRecord(int n) {
        int MOD = (int) (1e9 + 7);
        int[][][] f = new int[n + 1][2][3];
        f[0][0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    if (j + 1 < 2) {
                        f[i + 1][j + 1][0] = (f[i + 1][j + 1][0] + f[i][j][k]) % MOD;
                    }
                    f[i + 1][j][0] = (f[i + 1][j][0] + f[i][j][k]) % MOD;
                    if (k + 1 < 3) {
                        f[i + 1][j][k + 1] = (f[i + 1][j][k + 1] + f[i][j][k]) % MOD;
                    }
                }
            }
        }
        
        int res = 0;
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                res = (res + f[n][j][k]) % MOD;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().checkRecord(10101));
    }
}
