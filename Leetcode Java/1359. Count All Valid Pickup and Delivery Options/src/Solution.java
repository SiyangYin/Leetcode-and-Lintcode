public class Solution {
    public int countOrders(int n) {
        long MOD = (long) (1e9 + 7);
        
        long res = 1L;
        for (int i = 1; i < n; i++) {
            res = res * (i + 1) * (2L * i + 1) % MOD;
        }
        
        return (int) res;
    }
}
