public class Solution {
    /**
     * @param n:   the number of steps
     * @param num: the maximum step Ming can run up at the ith step
     * @return: Return the number of ways to run up the stairs
     */
    public long Solve(int n, int[] num) {
        // Write your code here
        long[] diff = new long[n + 1];
        long MOD = (long) 1E9 + 7;
        diff[0] = 1;
        diff[1] = -1;
        
        long res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + diff[i]) % MOD;
            
            int l = i + 1, r = Math.min(n, i + num[i]);
            if (l < diff.length) {
                diff[l] = (diff[l] + res) % MOD;
            }
            if (r + 1 < diff.length) {
                diff[r + 1] = (diff[r + 1] - res) % MOD;
            }
        }
        
        res = (res + diff[n]) % MOD;
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().Solve(3, new int[]{3, 2, 1}));
    }
}
