public class Solution2 {
    public int findDerangement(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        
        int MOD = (int) (1E9+7);
        long fac = 1, res = 0;
        for (int i = n; i >= 0; i--) {
            res = (res + fac * (i % 2 == 0 ? 1 : -1) + MOD) % MOD;
            fac = (fac * i) % MOD;
        }
        
        return (int) ((res + MOD) % MOD);
    }
}
